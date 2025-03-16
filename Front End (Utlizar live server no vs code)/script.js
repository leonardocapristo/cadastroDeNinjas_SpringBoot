const baseUrl = "http://localhost:8080/ninjas";

// Buscar todos os ninjas
document.getElementById("fetchAll").addEventListener("click", async () => {
  const response = await fetch(baseUrl);
  const ninjas = await response.json();
  displayNinjas(ninjas);
});

// Buscar ninja por ID
document.getElementById("fetchById").addEventListener("click", async () => {
  const id = document.getElementById("searchId").value;
  const response = await fetch(`${baseUrl}/${id}`);
  const ninja = await response.json();
  displayNinjaDetail(ninja);
});

// Adicionar ninja
document.getElementById("addNinja").addEventListener("click", async () => {
  const name = document.getElementById("addName").value;
  const idade = document.getElementById("addIdade").value;

  const response = await fetch(`${baseUrl}/add`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ name, idade }),
  });

  const newNinja = await response.json();
  alert(`Ninja ${newNinja.name} (ID: ${newNinja.id}) adicionado com sucesso!`);
  document.getElementById("addName").value = "";
  document.getElementById("addIdade").value = "";
});

// Atualizar ninja
document.getElementById("updateNinja").addEventListener("click", async () => {
  const id = document.getElementById("updateId").value;
  const name = document.getElementById("updateName").value;
  const idade = document.getElementById("updateIdade").value;

  const response = await fetch(`${baseUrl}/update/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ name, idade }),
  });

  const updatedNinja = await response.json();
  alert(`Ninja ${updatedNinja.name} (ID: ${updatedNinja.id}) atualizado com sucesso!`);
  document.getElementById("updateId").value = "";
  document.getElementById("updateName").value = "";
  document.getElementById("updateIdade").value = "";
});

// Deletar ninja
document.getElementById("deleteNinja").addEventListener("click", async () => {
  const id = document.getElementById("deleteId").value;
  await fetch(`${baseUrl}/remove/${id}`, {
    method: "DELETE",
  });
  alert(`Ninja com ID ${id} deletado com sucesso!`);
  document.getElementById("deleteId").value = "";
});

// Função para exibir todos os ninjas
function displayNinjas(ninjas) {
  const ninjaList = document.getElementById("ninjaList");
  ninjaList.innerHTML = "";
  ninjas.forEach(ninja => {
    const ninjaItem = document.createElement("div");
    ninjaItem.classList.add("ninja-item");
    ninjaItem.innerHTML = `<strong>ID: ${ninja.id}</strong> - Nome: ${ninja.name} - Idade: ${ninja.idade}`;
    ninjaList.appendChild(ninjaItem);
  });
}

// Função para exibir detalhes de um ninja
function displayNinjaDetail(ninja) {
  const ninjaDetail = document.getElementById("ninjaDetail");
  ninjaDetail.innerHTML = `<strong>ID: ${ninja.id}</strong> - Nome: ${ninja.name} - Idade: ${ninja.idade}`;
}
