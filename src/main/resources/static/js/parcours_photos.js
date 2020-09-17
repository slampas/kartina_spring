//Collection regroupant toutes les checkbox et labels du formulaire Orientation
let checkboxesLabelsOrientation = document.getElementsByClassName("div_checkbox_label_Orientation");
//Collection regroupant toutes les checkbox et labels du formulaire Formats
let checkboxesLabelsFormats = document.getElementsByClassName("div_checkbox_label_Formats");
//Collection regroupant toutes les checkbox et labels du formulaire Prix
let checkboxesLabelsPrix = document.getElementsByClassName("div_checkbox_label_Prix");

//Titres des formulaires
let titreOrientation = document.getElementById("titre_Orientation");
let titreFormat = document.getElementById("titre_Formats");
let titrePrix = document.getElementById("titre_Prix");

let estAfficher = false; //Est ce que le lien (Effacer) est affiché ? 

//Listes de liens
let listeThemes = document.getElementById("liste_theme");   //La liste des thèmes
let listeFiltrageAvance = document.getElementById("liste_filtrage_avance");

//Ajout des events sur les collections (div [checkbox+label])
ajoutEventFormulaire(checkboxesLabelsOrientation, titreOrientation);
ajoutEventFormulaire(checkboxesLabelsFormats, titreFormat);
ajoutEventFormulaire(checkboxesLabelsPrix, titrePrix);

//Ajout des events sur les listes
ajoutEventListe(listeThemes);
ajoutEventListe(listeFiltrageAvance);


//Fonction d'ajout d'evenement sur les formulaires
function ajoutEventFormulaire(collection, titre) {
    for (let i = 0; i < collection.length; i++) {
        collection[i].addEventListener("click", function () {
            changeColorLabel(collection);       //Change la couleur du label lors de la selection
            displayEffacer(collection, titre);  //Ajoute un lien Effacer pour reset la selection si un input est coché             
            console.log(getAllChoices());       //Recupére les filtres selectionnes pour les formulaires      
        });
    }
}

//Fonction d'ajout d'evenement sur les items de liste des thèmes
function ajoutEventListe(element) {
    for (let i = 0; i < element.children.length; i++) {
        element.children[i].addEventListener("click", function () {
            changeCssLink(this);
            setTitleTheme(this);
        })
    }
}
//Ajoute le titre du thème dans la section resultat
function setTitleTheme(element) {
    let divTitre = document.getElementById("section_resultat_theme_choisi");
    let titreLien = element.outerText;

    //Ajout d'un <p>$titre</p> dans la div
    divTitre.innerHTML = `<p id="titre_theme_resultat">${titreLien}</p>`;

    //Ajout de la description du thème selectionné dans la div
    divTitre.innerHTML += `<p id="description_theme_resultat">[Description ${titreLien}] : Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque qui quibusdam dicta suscipit necessitatibus quod ex fugiat quasi, reprehenderit possimus officia ut voluptatibus repellendus veritatis unde quaerat iure aliquid voluptates?
    Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque qui quibusdam dicta suscipit necessitatibus quod ex fugiat quasi, reprehenderit possimus officia ut voluptatibus repellendus veritatis unde quaerat iure aliquid voluptates?</p>`;
}

function changeCssLink(element) {
    let elementUl = element.parentElement;

    //Suppression de la regle css sur tout les items si elle existe
    for (let i = 0; i < elementUl.childElementCount; i++) {
        if (elementUl.children[i].classList.contains("theme_clique")) {
            elementUl.children[i].classList.remove("theme_clique");
        }
    }
    element.classList.add("theme_clique");  //Ajout de la regle css sur l'element cliqué
}

//Change la color des elements de la collection non cochés en gris, et ceux cochés en noir
function changeColorLabel(collection) {
    for (let i = 0; i < collection.length; i++) {
        if (collection[i].children[0].checked) {
            collection[i].children[1].style.color = "black";
        } else {
            collection[i].children[1].style.color = "grey";
        }
    }
}

//Récupere les données selectionnées dans les formulaire
function getAllChoices() {
    let SelectedChoices = "";
    //Pour chaque formulaires présent dans la page
    for (let i = 0; i < document.forms.length; i++) {
        //Pour chaque elements dans chaque formulaires, concatenation des choix selectionnés
        for (let j = 0; j < document.forms[i].length; j++)
            if (document.forms[i][j].checked) {
                SelectedChoices += `${document.forms[i][j].value},`;
            }
    }
    return SelectedChoices;
}

//Ajoute un lien Effacer pour reset la selection si un input est coché
function displayEffacer(form, titre) {
    let elementEffacer = document.getElementById(`lien_${titre.id}`);
    let htmlLinkEffacer = ` <a id="lien_${titre.id}" class="lien_effacer" href="javascript:void(0)" onClick="reset(this);">(Effacer)</a>`;

    //Est-ce que l'element Effacer existe déjà ?
    if (elementEffacer !== null) {
        estAfficher = true;
    } else {
        estAfficher = false;
    }

    //Quand input (par formulaire) coché => Ajout du lien Effacer (par formulaire) s'il n'existe pas déjà
    for (let i = 0; i < form.length; i++) {
        let isChecked = form[i].children[0].checked;    //Cible la value de la checkbox

        if (isChecked && !estAfficher) {
            titre.innerHTML += htmlLinkEffacer;         //Ajout du lien effacer a coté du titre
            estAfficher = true;
        }
    }
}

//Efface la selection du formulaire et lui même
function reset(element) {
    let form = element.parentElement.parentElement; //On remonte de deux hiérarchies pour recuperer le formulaire concerné

    //Décoche tout les inputs du formulaire et label en gris
    for (let i = 0; i < form.length; i++) {
        form[i].checked = false;
        form[i].nextElementSibling.style.color = "black";
    }
    element.remove();                               //Supprime le lien lui-même  
    console.log(getAllChoices());                   //Mise à jour des données selectionnées restante
}