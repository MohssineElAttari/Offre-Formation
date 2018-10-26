
function deleteProfesseur(id) {
    swal({
        title: "Are you sure?", text: "Once deleted, you will not be able to recover this imaginary file!",
        icon: "warning", buttons: true, dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            $.ajax({
                url: '../../DeleteProfesseur',
                type: 'post',
                dataType: 'json',
                data: {'id': id},
                success: function (response) {
                    display(response);
                }
            });
        }
    });
}

function addProfesseur() {
    var nom = $("#nom").val();
    var prenom = $("#prenom").val();
    var tel = $("#tel").val();
    var email = $("#email").val();
    var specialite = $("#specialite").val();
    var dateE = $("#dateEmbouche").val();
    var sexe = $("#sexe").val();

    $.ajax({
        url: "../../AddProfesseur",
        type: "post",
        dataType: 'json',
        data: {"nom": nom, "prenom": prenom, "tel": tel, "email": email, "specialite": specialite, "dateE": dateE, "sexe": sexe},
        success: function (response) {
            display(response);
            swal("Good job!", "You Insert the Prof!", "success");
            clearFields();
        }
    });

}

function updateProfesseur(id) {
    $("#saveProf").val("Enregistrer");
    $.ajax({
        url: '../../FindProfById',
        type: 'post',
        dataType: 'json',
        data: {'id': id},
        success: function (response) {
            console.log(response);
            $("#nom").val("" + response.nom);
            $("#prenom").val("" + response.prenom);
            $("#tel").val("" + response.telephone);
            $("#email").val("" + response.email);
            $("#dateEmbouche").val("" + response.dateEmbouche);
        }
    });
}

function fetchProfesseur() {
    $.ajax({
        url: "../../FetchProfesseur",
        type: "post",
        success: function (response) {
            display(response);
        }
    });
}

function display(response) {
    console.log(response);
    var profs = "";
    for (var i = 0; i < response.length; i++) {
        profs += "<tr><td>" + response[i][0].nom + "</td><td>" + response[i][0].prenom + "</td><td>" + response[i][0].telephone
        profs += "</td><td>" + response[i][0].email + "</td><td>" + response[i][0].sexe + "</td><td>" + response[i][1].libelle
        profs += "</td><td>" + response[i][0].dateEmbouche
        profs += "</td><td><Button onclick='deleteProfesseur(" + response[i][0].id + ")' class='btn btn-danger' >Supprimer</Button></td>"
        profs += "<td><Button onclick='updateProfesseur(" + response[i][0].id + ")' class='btn btn-info' id ='update'>Modifier</Button></td></tr>";
    }
    $("#mTable").empty();
    $("#mTable").html(profs);
}

function clearFields() {
    $("#nom").val("");
    $("#prenom").val("");
    $("#tel").val("");
    $("#email").val("");
    $("#dateEmbouche").val("");
}



