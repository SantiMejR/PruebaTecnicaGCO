document.addEventListener("DOMContentLoaded", () => {
  cargarSelect("Cod_Pais", "/paises/listar", "Pais");
  cargarSelect("Cod_Departamento", "/departamentos/listar", "Departamento", "Cod_Pais");
  cargarSelect("Cod_Ciudad", "/ciudades/listar", "Ciudad", "Cod_Departamento");
  cargarSelect("Cod_Identificacion", "/tipos-identificacion/listar", "Tipo");
  cargarSelect("Id_Marca", "/marca/listar", "Marca");

  document.getElementById("formularioCliente").addEventListener("submit", enviarFormulario);
});

function cargarSelect(idSelect, endpoint, idField, textField) {
  fetch(endpoint)
    .then(res => res.json())
    .then(data => {
      const select = document.getElementById(idSelect);
      select.innerHTML = '<option value="">Seleccione...</option>';
      data.forEach(item => {
        const option = document.createElement("option");
        option.value = item[idField];
        option.textContent = item[textField];
        select.appendChild(option);
      });
    })
    .catch(error => console.error(`Error al cargar ${idSelect}:`, error));
}

function enviarFormulario(event) {
  event.preventDefault();

  const numeroIdentificacion = prompt("Ingrese el número de identificación del cliente:");
  if (!numeroIdentificacion || numeroIdentificacion.trim() === "") {
    alert("El número de identificación es obligatorio.");
    return;
  }

  const datos = {
    numeroIdentificacion: numeroIdentificacion.trim(),
    idMarca: document.getElementById("Id_Marca").value
  };

  fetch("/cliente-por-marca/crear", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(datos)
  })
  .then(res => {
    if (!res.ok) throw new Error("Error en el envío");
    return res.json();
  })
  .then(respuesta => {
    alert("Cliente registrado correctamente");
    console.log("Respuesta del servidor:", respuesta);
  })
  .catch(error => {
    alert("Hubo un problema al registrar el cliente");
    console.error("Error:", error);
  });
}