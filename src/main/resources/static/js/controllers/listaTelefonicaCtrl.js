angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, $filter, contatosAPI, operadorasAPI) {
  $scope.app = "Lista Telefonica";
  $scope.limit = 2;
  $scope.checked = 0;
  $scope.contatos = [];
  $scope.operadoras = [];


  var listarContatos = function() {
        contatosAPI.getContatos().then(function(response) {
            $scope.contatos = response.data;
        });
    };

  var listarOperadoras = function() {
    operadorasAPI.getOperadoras().then(function(response) {
          $scope.operadoras = response.data;
        });
    };

  $scope.adicionarContato = function (contato) {
    contato.data = new Date();
    contatosAPI.saveContato(contato).then(function(response) {
        delete $scope.contato;
        $scope.contatoForm.$setPristine();
        listarContatos();
      });
  };

  $scope.apagarContatos = function (contatos) {
	  let sendList = contatos.filter(function (contato) {
		 if (contato.selecionado) {
			 return contato;
		 };
      });
	  contatosAPI.deleteContatos(sendList).then(function(response) {
          return listarContatos();
	  });
  };

  $scope.isContatoSelecionado = function (contatos) {
    return contatos.some(function (contato) {
      return contato.selecionado;
    });
  };
  $scope.ordenarPor = function (campo) {
    $scope.ordenacao = campo;
    $scope.direcao = !$scope.direcao;
  };

  $scope.checkChanged = function(contato){
    if(contato.selecionado) {
      $scope.checked++;
    } else {
      $scope.checked--;
    }
  }
  listarContatos();
  listarOperadoras();
});
