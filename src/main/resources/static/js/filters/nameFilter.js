angular.module("listaTelefonica").filter("name", function () {
	return function (input) {
		let listaDeNomes = input.split(" ");
		let listaFormatada = listaDeNomes.map(function (nome) {
			if (/(da|de|do|dos|das)/.test(nome)) return nome.toLowerCase();
			return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase();
		});
		return listaFormatada.join(" ");
	};
});