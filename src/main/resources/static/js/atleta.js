
var url = '';

//Recupera evento de exclusão
//Quando evento CLICK localizar botão com ID = btnExcluir_	
$('button[id*="btnExcluir_"]').click(function() {
	url = "../" + $(this).attr('id').split("_")[1];

});

$('#btn_confirmar').click(function() {
	console.log("url " + url);
	document.location.href = url;
});


function verifica_valor(param) {
	var x = document.getElementById(param);
	if (x.value === null) {
		console.log("Selecionar opção no combo");
		alert("Selecione uma opção no combo");

	}
}

function mostra_oculta(param) {
	var x = document.getElementById(param);
	if (x.style.display === "none") {
		x.style.display = "block";

	} else {
		x.style.display = "none";

	}
}

function editar(id) {
	console.log("Funcao Editar");
	console.log("id atleta " + id);
	location.href = "../atleta/editar/" + id;

}

function excluir(id, nome) {
	console.log("Funcao Excluir");
	console.log("id atleta: " + id);
	console.log("nome atleta: " + nome);
	location.href = "../atleta/excluir?id=" + id + "&nome=" + nome;
}

/*	Exibir notificação */
function loadToast() {
	$('.toast').toast('show');
}
