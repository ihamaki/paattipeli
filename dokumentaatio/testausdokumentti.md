## Testausdokumentaatio

Ohjelman kaikkia logiikkaluokkia on testattu automaattisesti. Rivikattavuuden ja mutaatiokattavuuden (molemmat >95%) perusteella testejä vaikuttaisi olevan riittävästi. Logiikkaluokkien jokaista metodia on pyritty testaamaan erilaiset rajatapaukset huomioiden, joten logiikan testaukseen olen ihan tyytyväinen. 

Käyttöliittymään liittyvistä luokista mitään ei ole testattu automaattisin testein. Sen sijaan käyttöliittymää on testattu käsin mahdollisimman monipuolisesti. Laivoja lisättäessä käyttöliittymä ilmoittaa virheviestillä, jos laivaa yritetään lisätä kelvottomaan ruutuun, jos laivaa ei ole valittu, tai jos laudalta puuttuu vielä laivoja. Vain vuorossa olevaa lautaa voi klikata, ja kaikkien klikattavissa olevien nappien/ruutujen klikkaus toimii testauksen perusteella. Varsinaisen pelin edetessä pelissä voi klikata vain vuorossa olevaa lautaa, ja pelin käyttöliittymä myös ilmoittaa kumpi on vuorossa. Kaikkien laivojen löydyttyä peli ilmoittaa voittajan, eikä ruutuja tämän jälkeen enää voi klikata. Käsin testauksen perusteella kaikki näyttää toimivan kuten pitääkin.

Mitään varsinaisia bugeja ei ohjelman nykyisestä toteutuksesta ole tullut vastaan. Pelin ja käyttöliittymän toteutus on hyvin yksinkertainen, joten tilaa bugeillekaan ei pitäisi kauheasti olla.
