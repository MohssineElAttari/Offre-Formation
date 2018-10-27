
function deleteProfesseur(id) {
    swal({
        title: "Voulez-vous vraiment le supprimer?", text: "Une fois supprimer,vous pouvez pas le recuperer!",
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
    var id_update = $('#idupdate');
    var nom = $("#nom").val();
    var prenom = $("#prenom").val();
    var tel = $("#tel").val();
    var email = $("#email").val();
    var specialite = $("#specialite").val();
    var dateE = $("#dateEmbouche").val();
    var sexe = $("#sexe").val();
    var btn_save = $('#saveProf');

    $.ajax({
        url: "../../AddProfesseur",
        type: "post",
        dataType: 'json',
        data: {"nom": nom, "prenom": prenom, "tel": tel, "email": email, "specialite": specialite, "dateE": dateE, "sexe": sexe, "idupdate": id_update.val()},
        success: function (response) {
            if(btn_save.val() == "Ajouter"){
            display(response);
            swal("Bien Insérer!", "", "success");
            clearFields();
        }else{
            display(response);
            swal("Bien Modifier!", "", "success");
            clearFields();
            id_update.val("");
            btn_save.val("Ajouter");
        }
        }
    });

}

function updateProfesseur(idV,nomV,prenomV,telV,emailV,sexeV,specialiteV,dateV) {
    var id_update = $('#idupdate');
    var nom = $("#nom");
    var prenom = $("#prenom");
    var tel = $("#tel");
    var email = $("#email");
    var specialite = document.getElementById("specialite");
    var dateE = $("#dateEmbouche");
    var sexe = document.getElementById("sexe");
    var btn_save = $('#saveProf');
    
    id_update.val(idV);
    nom.val(nomV);
    prenom.val(prenomV);
    tel.val(telV);
    email.val(emailV);    
    dateE.val(dateV);
    
    for (var i = 0; i < specialite.options.length; i++) {
       if(specialite.options[i].text == specialiteV){
           specialite.options.selectedIndex = i;
           break;
       }
    }
    
    for (var i = 0; i < sexe.options.length; i++) {
        if (sexe.options[i].text == sexeV) {
            sexe.options.selectedIndex = i;
            break;
        }
    }
    
    btn_save.val("Modifier");
    
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
        var date = moment(new Date(response[i][0].dateEmbouche)).format('L').replace(/(\d\d)\/(\d\d)\/(\d{4})/, "$3-$1-$2");;
        profs += "<tr><td>" + response[i][0].nom + "</td><td>" + response[i][0].prenom + "</td><td>" + response[i][0].telephone;
        profs += "</td><td>" + response[i][0].email + "</td><td>" + response[i][0].sexe + "</td><td>" + response[i][1].libelle;
        profs += "</td><td>" + date;
        profs += "</td><td><Button onclick='deleteProfesseur(" + response[i][0].id + ")' class='btn btn-danger' >Supprimer</Button></td>";
        var func = "updateProfesseur("+response[i][0].id+",'"+response[i][0].nom+"','"+response[i][0].prenom+"','"+response[i][0].telephone+"','"+response[i][0].email+"','"+response[i][0].sexe +"','"+response[i][1].libelle+"','"+date+"')";
        profs += "<td><Button onclick="+func+" class='btn btn-info' id ='update'>Modifier</Button></td></tr>";
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



