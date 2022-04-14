function editStudent(id, name, email, password) {
    document.getElementById("editModalForm").action = "/student/update/" + id;
    document.getElementById("editName").value = name;
    document.getElementById("editEmail").value = email;
    document.getElementById("editPassword").value = password;
}

function editProfessor(id, name, disciplina, email, password) {
    document.getElementById("editModalProfessorForm").action = "/professor/update/" + id;
    document.getElementById("editNameT").value = name;
	document.getElementById("editDisciplinaT").value = disciplina;
    document.getElementById("editEmailT").value = email;
    document.getElementById("editPasswordT").value = password;
}