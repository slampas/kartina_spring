function checkbox(element) {
    let form = element.form;
    let btn = form[form.length - 1];

    for (let i = 0; i < form.length - 1; i++) { // -1 pour le button
        let label = form[i].previousElementSibling;
        //Un seul case coché à la fois possible
        form[i].checked = false;
        element.checked = true;

        //choix selectionne encadre
        if (form[i].checked) {
            label.style.border = "2px solid #0075ff";
        } else {
            label.style.border = "";
        }
    }
    //Activation du bouton
    btn.disabled = false;
}


