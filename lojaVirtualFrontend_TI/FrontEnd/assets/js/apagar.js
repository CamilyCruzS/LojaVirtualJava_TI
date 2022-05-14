function apagar(){

if (confirm('Você deseja apagar o produto?')==true) {
    //pegando o produto pelo id
    var id = window.location.search.substring(4,window.location.search.length);
    fetch("http://localhost:8080/produtos", {
        //deletando produto
        method:"DELETE",
        headers:{
            accept:"application/json",
            "content-type":"application/json"
        },
        body:JSON.stringify({
            idproduto:id
        })
    })
    //Abaixo não colocamos response json pois DELETE não tem resposta
    .then(() => {
        alert('Produto apagado!');
        window.history.back();  //Voltando pra a página anterior
    })
    //Tratamento de erro
    .catch((erro) => console.error('Erro ao tentar apagar produto -> &{erro}')) 

    } else
    window.history.back();  //Voltando pra a página anterior
}
