//POST(CADASTRAR)
const btnCadastrar = document.getElementById("btnCadastrar");
btnCadastrar.onclick = ()=>{
    const nomeproduto = document.getElementById("nomeproduto");
    const preco = document.getElementById("preco");
    const foto = document.getElementById("foto");
    const descricao = document.getElementById("descricao");

    fetch("http://localhost:8080/produtos",{
        method:"POST",
        headers:{
            accept:"application/json",
            "content-type":"application/json"
        },
        body:JSON.stringify({
            nomeproduto:nomeproduto.value,
            descricao:descricao.value,
            preco:preco.value,
            foto:foto.value
        })
    })
    .then((response) => response.json())
    .then((rs) =>{
        //console.log(rs);
        alert("Produto cadastrado com sucesso");
        nomeproduto.value = "";
        preco.value = "";
        descricao.value = "";
        foto.value = "";
    })

    .catch((erro) => console.error('Erro ao tentar cadastrar os dados -> ${erro}'))

    function carregarProdutos(){
        const listaProdutos = document.getElementById("listaProdutos");

        var estrutura = "";

        fetch("http://localhost:8080/produtos")
        .then((response) => response.json())
        .then((dados) => {
            dados.map((item) => {
                estrutura+="<div id='linha'>";

                estrutura+="<div id='img'><img src="+item.foto+"></div>";

                estrutura+="<div id='produto'>"+item.nomeproduto+"</div>";

                estrutura+="<div id='preco'>"+item.preco+"</div>";

                estrutura+="<div id='atualizar'><a href=atualizar.html?id="+item.idproduto+">atualizar</a></div>";

                estrutura+="<div id='apagar'><a href=apagar?id="+item.idproduto+" onclick=alert>apagar</a></div>";

                estrutura+="</div>";
            })
            listaProdutos.innerHTML = estrutura;
        })
        .catch((erro) => console.error('Erro ao carregar a API -> ${erro}'))
    }
    function produtosAtualizar() {
        var id = window.location.search.substring(4,5);

        const nomeproduto = document.getElementById("nomeproduto");
        const preco = document.getElementById("preco");

        const foto = document.getElementById("foto");
        const descricao = document.getElementById("descricao");

        fetch("http://localhost:8080/produtos")
        .then((response) => response.json())
        .then((dados) => {
            nomeproduto.value = dados.nomeproduto;
            preco.value = dados.preco;
            foto.value = dados.foto;
            descricao.value = dados.descricao;
        })
        .catch((erro) => console.error('Erro ao cadastrar produto -> &{erro}'))
    }



//PUT(ATUALIZAR)
    const btnAtualizar = document.getElementById("btnAtualizar");
    btnAtualizar.onclick=() => {
        const nomeproduto = document.getElementById("nomeproduto");
        const preco = document.getElementById("preco");
        const foto = document.getElementById("foto");
        const descricao = document.getElementById("descricao");

    fetch("http://localhost:8080/produtos",{
        method:"PUT",
        headers:{
            accept:"application/json",
            "content-type":"application/json"
        },
        body:JSON.stringify({
            nomeproduto:nomeproduto.value,
            descricao:descricao.value,
            preco:preco.value,
            foto:foto.value
        })
    })
    .then((response) => response.json())
    .then((rs) =>{
        //console.log(rs);
        alert("Produto atualizado com sucesso");
        nomeproduto.value = "";
        preco.value = "";
        descricao.value = "";
        foto.value = "";
    })

    .catch((erro) => console.error('Erro ao tentar cadastrar os dados -> ${erro}'))
    }
}