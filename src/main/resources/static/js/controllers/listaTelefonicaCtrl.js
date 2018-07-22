angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, $filter, contatosAPI, operadorasAPI) {
  $scope.app = "Lista Telefonica";
  $scope.limit = 2;
  $scope.checked = 0;
  $scope.contatos = [];
  $scope.operadoras = [];


  var contatos = function() {
        contatosAPI.getContatos().then(function(response) {
            $scope.contatos = response.data;
        });
    };

  var operadoras = function() {
    operadorasAPI.getOperadoras().then(function(response) {
          $scope.operadoras = response.data;
        });
    };

  $scope.adicionarContato = function (contato) {
    contato.data = new Date();
    contatosAPI.saveContato(contato).then(function(response) {
        delete $scope.contato;
        $scope.contatoForm.$setPristine();
        contatos();
      });
  };

  $scope.apagarContatos = function (contatos) {
      contatosAPI.deleteContatos(contatos).then(function(response) {
          contatos();
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
  contatos();
  operadoras();
});
