function submitForm() {
    var nome = document.getElementById("name").value;
    var contacto = document.getElementById("contact").value;
    var idade = document.getElementById("age").value;
    var morada = document.getElementById("address").value;
    var profissao = document.getElementById("profissao").value;

    // Send data to the backend
    fetch('/noesis/candidatos/criar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nome: nome, contacto: contacto, idade: idade, morada: morada, profissao: profissao})
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
};

function getCandidates(){ 
    fetch('noesis/candidatos', {
        method: 'GET',
        headers: {
            'Content-Type' : 'application/json'
        },
    })
    .then(response => response.json())
    .then(json =>{
        let li = '<tr><th>ID</th><th>Nome</th><th>Contacto</th><th>Idade</th><th>Morada</th><th>Profissao</th></tr>';

        json.forEach((tab1) => {
          li += `<tr>
            <td>${tab1.id}</td>
            <td>${tab1.nome}</td>
            <td>${tab1.contacto} </td>
            <td>${tab1.idade}</td>
            <td>${tab1.morada}</td>
            <td>${tab1.profissao.descricao}</td>
            <td><button onclick="deleteCandidate(${tab1.id})">Eliminar</button> <button id="editBtn" onclick="editCandidate(${tab1.id})">Editar</button></td>
          </tr>`;
        });
    
        document.getElementById("tab1").innerHTML = li;
    })
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
};

function deleteCandidate(id){
    id = Number(id);

    fetch('/noesis/candidatos/apagar/' + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });

    location.reload();
}

function editCandidate(id){
    document.getElementById("updateForm").style.display = "block";
    document.getElementById("createForm").style.display = "none";

    id = Number(id);

    fetch('noesis/candidatos/' + id, {
        method: 'GET',
        headers: {
            'Content-Type' : 'application/json'
        },
    })
    .then(response => response.json())
    .then(json =>{
        document.getElementById("idUp").value = json.id
        document.getElementById("nameUp").value = json.nome;
        document.getElementById("contactUp").value = json.contacto;
        document.getElementById("ageUp").value = json.idade;
        document.getElementById("addressUp").value = json.morada;
        document.getElementById("profissaoUp").value = json.profissao.descricao;
    })
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function updateCandidate(){
    var id = document.getElementById("idUp").value;
    id = Number(id);
    var nome = document.getElementById("nameUp").value;
    var contacto = document.getElementById("contactUp").value;
    var idade = document.getElementById("ageUp").value;
    var morada = document.getElementById("addressUp").value;
    var profissao = document.getElementById("profissaoUp").value;

    fetch('/noesis/candidatos/editar/' + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nome: nome, contacto: contacto, idade: idade, morada: morada, profissao: profissao})
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
