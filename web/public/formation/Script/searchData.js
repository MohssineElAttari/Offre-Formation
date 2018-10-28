
$('#formations').change(function () {
    var id = $('#formations').val();

    let container = $('#mTable');

    $.ajax({
        url: "../../FilterByFormation",
        type: 'GET',
        data: {id: id},
        success: function (data) {
            container.empty();
            container.html(feedTable(data));
        },
        error: function (errorThrown) {
            console.log("Error Ajax :" + errorThrown);
        }
    });
});

function feedTable(data) {
    var ft = "";
    var df = "-----";

    for (var i = 0; i < data.length; i++) {
        var dn = moment(new Date(data[i][0].dateDebut)).format('L');

        if (data[i][0].dateFin != undefined){
            df = moment(new Date(data[i][0].dateFin)).format('L');
        }
        ft += '<tr><td>' + data[i][0].id + '</td><td>' + data[i][0].nom + '</td><td>' + data[i][0].descr + '</td><td>' + data[i][0].prerequis + '</td><td>' + dn + '</td><td>' + df + '</td><td>' +  data[i][0].nbrplace + '</td><td>' +  data[i][0].lieu + '</td>';
        df = "-----";
    }

    return ft;
}

