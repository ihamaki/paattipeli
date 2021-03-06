## Paattipeli

**Aihe:** Projektin aiheena on laivanupotus-peli. Pelissä luodaan kullekin pelaajalle ruudukollinen pelilauta, jonne pelaajat sijoittavat laivansa. Tämän jälkeen pelaajat yrittävät löytää vastustajan laivat valitsemalla yksittäisiä ruutuja vastustajan laudalta. Peli ilmoittaa pelaajalle mahdollisesta osumasta/ohilaukauksesta. Peli etenee vuorotellen pelaajien välillä. Peli päättyy, jos toinen pelaajista upottaa kaikki vastustajan laivat.

**Käyttäjät:** 2 pelaajaa

**Käyttäjien toiminnot:** 
- aloita peli
- sijoita laivat omalle pelilaudalle
- etsi laivoja vastustajan pelilaudalta ruutuja klikkaamalla
- pelin päätyttyä sulje peli

**Luokkakaavio**

![Luokkakaavio](https://github.com/ihamaki/paattipeli/blob/master/dokumentaatio/luokkakaavio.png)

Pelilaudan kooksi on kaaviossa oletettu 10x10 ja laivojen määräksi 5.

**Rakennekuvaus**

Pelin logiikka löytyy luokista Peli, Lauta, Laiva ja Ruutu. Peli pitää sisällään kaksi lautaa, jotka taas pitävät sisällään kaksiulotteisen taulukon ruuduista, sekä listan pelilautaan liittyvistä laivoista. Laiva pitää sisällään ainoastaan tiedon ehjistä osistaan, ja siitä, onko se tuhoutunut. Ruutu sisältää tiedon siitä, onko sitä ammuttu ja tiedon mahdollisesta siihen liitetystä laivasta (ruutuun voi liittyä vain yksi laiva). Lauta-luokan metodien avulla laudan ruuduille lisätään laivat sekä ammutaan ruutuja. Lauta sisältää listan siihen liittyvistä laivoista, ja voi sen avulla tarkistaa, onko kaikki lautaan liitetyt laivat tuhottu vai ei. Peli-luokan kautta päästään käsiksi kumpaankin pelattavana olevaan lautaan. Peli sisältää myös metodit pelitilanteen tarkistamiseen, eli onko toinen pelaajista hävinnyt ja onko peli päättynyt. 

Pelin käyttöliittymään liittyvät luokat ovat Kayttoliittyma, Pelikentta, LaivojenKuuntelija ja PelinKuuntelija. Kayttoliittyma luo käyttöliittymän komponentit, joista pelilaudan graafinen esitys luodaan Pelikentta-luokan avulla. LaivojenKuuntelija-luokka reagoi laivojen lisäysvaiheessa pelilaudan klikkauksiin, ja PelinKuuntelija reagoi varsinaisen pelin aikaisiin muutoksiin.

**Sekvenssikaaviot**

Ensimmäisessä sekvenssikaaviossa klikataan ruutua pelivuorossa olevalta laudalta.

![Sekvenssikaavio1](https://github.com/ihamaki/paattipeli/blob/master/dokumentaatio/sekvenssi1.png)

Toisessa sekvenssikaaviossa klikataan ruutua väärältä laudalta, jolloin mitään ei tapahdu.

![Sekvenssikaavio2](https://github.com/ihamaki/paattipeli/blob/master/dokumentaatio/sekvenssi2.png)
