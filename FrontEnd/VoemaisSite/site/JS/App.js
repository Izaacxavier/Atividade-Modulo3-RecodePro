
//validacao
const validation = document.getElementById('validation');
     

//preencher input
const preencherFormulario = (endereco) =>{
   document.getElementById("address").value = endereco.logradouro;
   document.getElementById('neighborhood').value = endereco.bairro;
   document.getElementById('city').value = endereco.localidade;
   document.getElementById('region').value = endereco.uf;
};

// api 
const pesquisarCep = async() =>{
    const cep = document.getElementById('cep').value;
    const url = `http://viacep.com.br/ws/${cep}/json/`;
    const dados = await fetch(url);
    const endereco = await dados.json();
    if(endereco.hasOwnProperty('erro')){
        validation.classList.add('erro');
    }else {
        preencherFormulario(endereco);
        validation.classList.remove('erro');  
    }
};

// focusout
document.getElementById('cep')
        .addEventListener('focusout', pesquisarCep);


    