function checkbox(element) {
    debugger
    let form = element.form;
    let btn = form[form.length - 1];
    for (let i = 0; i < form.length - 1; i++) { // -1 pour le button
        //Un seul case coché à la fois possible
        form[i].checked = false;
        element.checked = true;
    }
    //Activation du bouton
    btn.disabled = false;
}