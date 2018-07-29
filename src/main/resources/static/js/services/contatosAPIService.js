angular.module("listaTelefonica").factory("contatosAPI", function ($http) {
	var _getContatos = function () {
		return $http.get('contatos/listar');
	};
	
	var _saveContato = function (contato) {
		return $http.post("contatos/salvar", contato);
	};
	
	var _deleteContatos = function (contatos) {
		return $http.post("contatos/deletar", contatos);
	}
	
	return {
		getContatos: _getContatos,
		saveContato: _saveContato,
		deleteContatos: _deleteContatos
	};
});