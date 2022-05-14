//window.addEventListener-Fazendo o navegador ouvir
//load-quando carregar
window.addEventListener("load" ,carregarProdutos);

function carregarProdutos(){
    //trazendo a API
    fetch("http://localhost:8080/produtos")

    //transformando a resposta em json
    .then((response)=>response.json())

    //colocando a resposta dentro da variavel "dados" e exibindo o conteudo da var "dados" na tela de console
    /* .then((dados)=>console.log(dados)) */

    //criando estrutura de repetição(repete de acordo com a qtde de produtos adicionados)
    .then((dados) => {
        dados.map((item)=>{

            estrutura+="<div class='col-md-4'">
                <div class="product-item">
                    <a href="#"><img src="assets/images/product_01.jpg" alt=""></a>
                    <div class="down-content">
                        <a href="#"><h4>Tittle goes here</h4></a>
                        <h6>$25.75</h6>
                        <p>Lorem ipsume dolor sit amet, adipisicing elite. Itaque, corporis nulla aspernatur.</p>
                        <ul class="stars">
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                        </ul>
                        <span>Reviews (24)</span>
                    </div>
                </div>
            </div>




        })
        
    })






    //tratamento de erro
    .catch((erro)=>console.error('Erro ao carregar a API de produtos -> {$erro}'))
}