/**
 * @author Fabricio
 */
//Variáveis Globais
ac_idx=0
ac_old=""
ac_showing=false

//Registra o autocompletar
function ac_registra(formulario,inputname,funcao){
    ac_campo=formulario.elements[inputname]
    addEvent(ac_campo, "keyup", ac_up)
    addEvent(ac_campo, "keypress", ac_mudou)
    addEvent(ac_campo, "focus", ac_focus)
    addEvent(ac_campo, "blur", ac_blur)
    ac_pegaLista=funcao
}
//Registra o autocompletar com um endereço Ajax/JSON
function ac_registraJSON(formulario,inputname,endereco){
    ac_JSON=endereco
    ac_registra(formulario,inputname,ac_getJSON)
}

//Função para obter o JSON
function ac_getJSON(t,func){
    ac_f=func
    xmlhttp.open("GET", ac_JSON+escape(t),true);
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4)
            ac_f(eval(xmlhttp.responseText))
    }
    xmlhttp.send(null)
}

//Monta a lista a partir de um Array
function ac_fazLista(t){
    ac_Lista=t
    var ret="<ul>"
    for(var i=0;i<ac_Lista.length;i++)
            ret+="<li"+(i==ac_idx?' class="selecionado"':'')+
            "><a href='javascript:ac_completa("+i+")'>"+
            ac_getHTML(ac_Lista[i])+"</a></li>"
    ret+="</ul>"
    document.getElementById("completando").innerHTML=ret
}

//Obtém o texto do item da lista
function ac_getText(i){return typeof(i)=="string"?i:i[1]}
//Obtém o HMTL do item da lista
function ac_getHTML(i){return typeof(i)=="string"?i:i[0]}

//Atualiza a lista de acordo com o conteúdo do campo
function ac_mudado(){
    ac_texto=ac_campo.value
    if(ac_old!=ac_texto)ac_idx=0
    ac_old=ac_texto
    setTimeout('ac_pegaLista(ac_texto,ac_fazLista)',100)
}

//Esconde a lista
function ac_some(){
    ac_showing=false
    try{document.getElementById("completando").style.display="none"}catch(e){}
}

//Mostra a lista
function ac_aparece(){
    ac_showing=true
    try{
        document.getElementById("completando").style.display="block"
    }catch(E){
        var d = document.createElement("div");
        d.setAttribute("id","completando")
        ac_campo.parentNode.appendChild(d)
    }
}

//Clique no completar
function ac_completa(l){
    try{
        ac_texto=ac_campo.value=ac_Lista[l]
        ac_campo.focus()
        setTimeout('ac_aparece()',110)
        ac_mudado()
    }catch(e){}
}

//Controla o índice do item selecionado
function ac_chItem(kCode){
    ac_idx+=kCode-39
    if(ac_idx<0)ac_idx=ac_Lista.length-1
    if(ac_idx>ac_Lista.length-1)ac_idx=0
    ac_mudado()
}

/* Eventos no textbox: */
//KeyPress
function ac_mudou(e){
    if(e.keyCode==40 || e.keyCode==38 || e.keyCode==13){
        if(e.keyCode!=13){
            if(!ac_showing)ac_aparece()
            ac_chItem(e.keyCode)
        }else{
            if(ac_Lista[ac_idx]==ac_campo.value || ac_Lista.length==0)return true
            if(ac_showing)ac_completa(ac_idx)
            else return true
        }
        if(e.preventDefault)e.preventDefault()
        return false
    }
    if(e.keyCode==27)ac_some()
    setTimeout('ac_mudado()',1)
}
//Tratando eventos no IE bugado
function ac_up(e){
    if(typeof e.target=="undefined" && (e.keyCode==40 || e.keyCode==38 || e.keyCode==8))ac_mudou(e)
}

//Focus
function ac_focus(e){
    ac_aparece()
    ac_mudado()
}
//Blur
function ac_blur(e){setTimeout('ac_some()',100)}
