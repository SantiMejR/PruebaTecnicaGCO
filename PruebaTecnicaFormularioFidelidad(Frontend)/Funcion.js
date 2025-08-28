const paisSelect = document.getElementById("pais");
const departamentoSelect = document.getElementById("departamento");
const ciudadSelect = document.getElementById("ciudad");
const tipoIdentificacionSelect = document.getElementById("tipoIdentificacion");
const marcaSelect = document.getElementById("marca");
const mensajeExito = document.getElementById("mensajeExito");

const datosColombia = {
  "Amazonas": ["Leticia", "Puerto Nariño", "Tarapacá"],
  "Antioquia": ["Medellín", "Envigado", "Itagüí"],
  "Arauca": ["Arauca", "Arauquita", "Saravena"],
  "Atlántico": ["Barranquilla", "Soledad", "Malambo"],
  "Bogotá": ["Usaquén", "Chapinero", "Suba"],
  "Bolívar": ["Cartagena", "Magangué", "Turbaco"],
  "Boyacá": ["Tunja", "Duitama", "Sogamoso"],
  "Caldas": ["Manizales", "Villamaría", "La Dorada"],
  "Caquetá": ["Florencia", "El Paujil", "La Montañita"],
  "Casanare": ["Yopal", "Villanueva", "Monterrey"],
  "Cauca": ["Popayán", "Puerto Tejada", "Santander de Quilichao"],
  "Cesar": ["Valledupar", "Aguachica", "La Paz"],
  "Chocó": ["Quibdó", "Istmina", "Condoto"],
  "Córdoba": ["Montería", "Lorica", "Sahagún"],
  "Cundinamarca": ["Soacha", "Chía", "Zipaquirá"],
  "Guainía": ["Inírida", "Barranco Minas", "La Guadalupe"],
  "Guaviare": ["San José del Guaviare", "Calamar", "Miraflores"],
  "Huila": ["Neiva", "Pitalito", "Garzón"],
  "La Guajira": ["Riohacha", "Maicao", "Fonseca"],
  "Magdalena": ["Santa Marta", "Ciénaga", "Fundación"],
  "Meta": ["Villavicencio", "Acacías", "Granada"],
  "Nariño": ["Pasto", "Ipiales", "Tumaco"],
  "Norte de Santander": ["Cúcuta", "Ocaña", "Pamplona"],
  "Putumayo": ["Mocoa", "Puerto Asís", "Sibundoy"],
  "Quindío": ["Armenia", "Montenegro", "Calarcá"],
  "Risaralda": ["Pereira", "Dosquebradas", "La Virginia"],
  "San Andrés y Providencia": ["San Andrés", "Providencia", "Santa Catalina"],
  "Santander": ["Bucaramanga", "Floridablanca", "Girón"],
  "Sucre": ["Sincelejo", "Corozal", "San Marcos"],
  "Tolima": ["Ibagué", "Espinal", "Melgar"],
  "Valle del Cauca": ["Cali", "Palmira", "Buenaventura"],
  "Vaupés": ["Mitú", "Taraira", "Yavaraté"],
  "Vichada": ["Puerto Carreño", "La Primavera", "Santa Rosalía"]
};


const marcas = [
    "Americanino", 
    "American Eagle", 
    "Chevignon", 
    "Esprit", 
    "Naf Naf", 
    "Rifle"
];
const tiposIdentificacion = [
  "Cédula de Ciudadanía",
  "Tarjeta de Identidad",
  "Pasaporte",
  "Cédula de Extranjería",
  "NIT"
];

function cargarIniciales() {
  const option = document.createElement("option");
  option.value = "Colombia";
  option.textContent = "Colombia";
  paisSelect.appendChild(option);

  tiposIdentificacion.forEach(tipo => {
    const opt = document.createElement("option");
    opt.value = tipo;
    opt.textContent = tipo;
    tipoIdentificacionSelect.appendChild(opt);
  });

  // Marca
  marcas.forEach(marca => {
    const opt = document.createElement("option");
    opt.value = marca;
    opt.textContent = marca;
    marcaSelect.appendChild(opt);
  });

  if (paisSelect.value === "Colombia") {
    departamentoSelect.innerHTML = '<option value="">Seleccione...</option>';
    Object.keys(datosColombia).forEach(dep => {
      const opt = document.createElement("option");
      opt.value = dep;
      opt.textContent = dep;
      departamentoSelect.appendChild(opt);
    });
  }
}

paisSelect.addEventListener("change", () => {
  departamentoSelect.innerHTML = '<option value="">Seleccione...</option>';
  ciudadSelect.innerHTML = '<option value="">Seleccione...</option>';

  if (paisSelect.value === "Colombia") {
    Object.keys(datosColombia).forEach(dep => {
      const opt = document.createElement("option");
      opt.value = dep;
      opt.textContent = dep;
      departamentoSelect.appendChild(opt);
    });
  }
});

departamentoSelect.addEventListener("change", () => {
  ciudadSelect.innerHTML = '<option value="">Seleccione...</option>';
  const ciudades = datosColombia[departamentoSelect.value] || [];
  ciudades.forEach(ciudad => {
    const opt = document.createElement("option");
    opt.value = ciudad;
    opt.textContent = ciudad;
    ciudadSelect.appendChild(opt);
  });
});

document.getElementById("formularioFidelidad").addEventListener("submit", (e) => {
  e.preventDefault();

  const datosCliente = {
    tipoIdentificacion: tipoIdentificacionSelect.value,
    numeroIdentificacion: document.getElementById("numeroIdentificacion").value,
    nombres: document.getElementById("nombres").value,
    apellidos: document.getElementById("apellidos").value,
    fechaNacimiento: document.getElementById("fechaNacimiento").value,
    direccion: document.getElementById("direccion").value,
    pais: paisSelect.value,
    departamento: departamentoSelect.value,
    ciudad: ciudadSelect.value,
    marca: marcaSelect.value
  };

  console.log("Datos enviados:", datosCliente);

  mensajeExito.classList.remove("d-none");

  setTimeout(() => {
    mensajeExito.classList.add("d-none");
    document.getElementById("formularioFidelidad").reset();
    ciudadSelect.innerHTML = '<option value="">Seleccione...</option>';
    departamentoSelect.innerHTML = '<option value="">Seleccione...</option>';
  }, 4000);
});

cargarIniciales();