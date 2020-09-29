function checkbox(element) {
    let form = element.form;
    let btn = form[form.length - 1];
    for (let i = 0; i < form.length - 1; i++) { // -1 pour le button
        //Un seul case coché à la fois possible
        form[i].checked = false;
        element.checked = true;
    }
    //Activation du bouton
    btn.disabled = false;

    //Activation des boutons etapes suivante
    let boutonsForward = document.getElementsByClassName("btn_forward");
    for (let i = 0; i < boutonsForward.length; i++) {
        boutonsForward[i].disabled = false;
    }
}

function goBack() {
    window.history.back();
}