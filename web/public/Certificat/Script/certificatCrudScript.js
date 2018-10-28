function deleteCertificat(id) {

    $.ajax({
        url: '../../DeleteCertificat',
        type: 'post',
        dataType: 'json',
        data: {'id': id},
        success: function (response) {
            console.log('bien supprimer');
            //display(response);
        }
    });
}

function addCertificat() {
    var id_update = $('#idupdate');
    var nom = $("#nom").val();
    var btn_save = $('#saveFor');

    $.ajax({
        url: "../../AddCertificat",
        type: "post",
        dataType: 'json',
        data: {"nom": nom},
        success: function (response) {
            if (btn_save.val() == "Ajouter") {
               // display(response);
                clearFields();
            } else {
                //display(response);
                clearFields();
                id_update.val("");
                btn_save.val("Ajouter");

            }
        }
    });

}

function clearFields() {
    $("#nom").val("");
}

function updateCertificat(idV, nomV) {
    var id_update = $('#idupdate');
    var nom = $("#nom");
    var btn_save = $('#saveFor');

    id_update.val(idV);
    nom.val(nomV);

}


