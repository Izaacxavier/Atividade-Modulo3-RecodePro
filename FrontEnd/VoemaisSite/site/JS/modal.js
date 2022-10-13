//modal login

function abrirModal(){
    const modal = document.getElementById('janela-modal') 
    modal.classList.add('open')
    modal.addEventListener('click', (e) =>{
        if(e.target.id == 'fechar' || e.target.id == 'janela-modal')
        modal.classList.remove('open')
    })
};

// modal cadastro
function modalCadastro(){
    const modalCadastro = document.getElementById('janela-modal-cadastro') 
    modalCadastro.classList.add('open')
    modalCadastro.addEventListener('click', (e) =>{
        if(e.target.id == 'fechar' || e.target.id == 'janela-modal-cadastro')
        modalCadastro.classList.remove('open')
    })
};


