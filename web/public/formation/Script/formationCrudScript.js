function deleteFormation(id) {

    $.ajax({
        url: '../../DeleteFormation',
        type: 'post',
        dataType: 'json',
        data: {'id': id},
        success: function (response) {
            console.log('bien');
            display(response);
        }
    });
}

function addFormation() {
    var id_update = $('#idupdate');
    var nom = $("#nom").val();
    var descr = $("#descr").val();
    var prerequis = $("#prerequis").val();
    var dateDebut = $("#dateDebut").val();
    var dateFin = $("#dateFin").val();
    var nbrplace = $("#nbrplace").val();
    var lieu = $("#lieu").val();
    var professeur = $("#professeur").val();
    var type = $("#type").val();
    var btn_save = $('#saveFor');

    $.ajax({
        url: "../../AddFormation",
        type: "post",
        dataType: 'json',
        data: {"nom": nom, "descr": descr, " prerequis": prerequis, "dateDebut": dateDebut, "dateFin": dateFin,
            "nbrplace": nbrplace, "lieu": lieu, "professeur": professeur, "type": type},
        success: function (response) {
            if (btn_save.val() == "Ajouter") {
                display(response);
                clearFields();
            } else {
                display(response);
                clearFields();
                id_update.val("");
                btn_save.val("Ajouter");

            }
        }
    });

}

function updateFormation(idV, nomV, descrV, prereqV, datedV, datefV, nbrpV, lieuV, profV, typeV) {
            var id_update = $('#idupdate');
            var nom = $("#nom");
            var descr = $("#descr");
            var prerequis = $("#prerequis");
            var dateDebut = $("#dateDebut");
            var dateFin = $("#dateFin");
            var nbrplace = $("#nbrplace");
            var lieu = $("#lieu");
            var professeur = document.getElementById(profV);
            var type = document.getElementById(typeV);
            var btn_save = $('#saveFor');

            id_update.val(idV);
            nom.val(nomV);
            descr.val(descrV);
            prerequis.val(prereqV);
            dateDebut.val(datedV);
            dateFin.val(datefV);
            nbrplace.val(nbrpV);
            lieu.val(lieu);
            
            for (var i = 0; i < professeur.options.length; i++) {
                if (professeur.options[i].text == profV) {
                    professeur.options.selectedIndex = i;
                    break;
                }
            }

            for (var i = 0; i < type.options.length; i++) {
                if (type.options[i].text == typeV) {
                    type.options.selectedIndex = i;
                    break;
                }
            }

}

function fetchFormation() {
    $.ajax({
        url: "../../FetchFormation",
        type: "post",
        success: function (response) {
            display(response);
        }
    });
}


function display(response) {
    console.log(response);
    var forms = "";
    for (var i = 0; i < response.length; i++) {
        var dated = moment(new Date(response[i][0].dateDebut)).format('L').replace(/(\d\d)\/(\d\d)\/(\d{4})/, "$3-$1-$2");;
        var datef = moment(new Date(response[i][0].dateFin)).format('L').replace(/(\d\d)\/(\d\d)\/(\d{4})/, "$3-$1-$2");;
        forms += "<tr><td>" + response[i][0].nom + "</td><td>" + response[i][0].descr + "</td><td>" + response[i][0].prerequis ; 
        forms += "</td><td>"+ dated  + "</td><td>" + datef + "</td><td>" + response[i][0].nbrplace ;
        forms +=  "</td><td>" + response[i][0].lieu + "</td><td>" + response[i][1].nom + "</td><td>" + response[i][2].nom;
        var func = "updateFormation("+response[i][0].id+",'"+response[i][0].nom+"','"+response[i][0].descr+"','"+response[i][0].prerequis+"','"+response[i][0].dateDebut+"','"+response[i][0].dateFin+"','"+response[i][0].nbrplace+"','"+response[i][0].lieu+"','"+response[i][1].nom+"','"+response[i][2].nom+"')";
        forms += "<td><Button onclick="+func+" class='btn btn-info' id ='update'>Modifier</Button></td></tr>";
    }
    $("#fTable").empty();
    $("#fTable").html(forms);
}

function clearFields() {
    $("#nom").val("");
    $("#descr").val("");
    $("#prerequis").val("");
    $("#dateDebut").val("");
    $("#dateFin").val("");
    $("#nbrplace").val("");
    $("#lieu").val("");
    $("#professeur").val("");
    $("#type").val("");
}

