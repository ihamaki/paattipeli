## Paattipeli

**Aihe:** Projektin aiheena on laivanupotus-peli. Pelissä luodaan kullekin pelaajalle ruudukollinen pelilauta, jonne pelaajat sijoittavat laivansa (5 kpl). Tämän jälkeen pelaajat yrittävät löytää vastustajan laivat valitsemalla yksittäisiä ruutuja vastustajan laudalta. Peli ilmoittaa pelaajalle mahdollisesta osumasta/ohilaukauksesta muuttamalla klikatun ruudun väriä. Peli etenee vuorotellen pelaajien välillä. Peli päättyy, jos toinen pelaajista upottaa kaikki vastustajan laivat. Tarkoituksena on aluksi toteuttaa perinteinen vuoropohjainen peli kahdelle pelaajalle. Tämän lisäksi ideana on luoda yksinkertainen tekoäly, jota vastaan yksittäinen pelaaja voi pelata.

**Käyttäjät:** 1-2 pelaajaa

**Käyttäjien toiminnot:** 
- aloita peli
- valitse pelityyppi (kaksinpeli/tietokonetta vastaan)
- sijoita laivat omalle pelilaudalle
- etsi laivoja vastustajan pelilaudalta ruutuja klikkaamalla
- pelin päätyttyä sulje peli/aloita uusi peli

**Luokkakaavio**

![Luokkakaavio](https://github.com/ihamaki/paattipeli/blob/master/dokumentaatio/luokkakaavio)

Pelilaudan kooksi on kaaviossa oletettu 10x10 ja laivojen määräksi 5.

**Rakennekuvaus**

Pelin logiikka löytyy luokista Peli, Lauta, Laiva ja Ruutu. 

**Sekvenssikaaviot**

Ensimmäisessä sekvenssikaaviossa klikataan ruutua pelivuorossa olevalta laudalta.

![Sekvenssikaavio1](https://github.com/ihamaki/paattipeli/blob/master/dokumentaatio/sekvenssi1.png)

Toisessa sekvenssikaaviossa klikataan ruutua väärältä laudalta, jolloin mitään ei tapahdu.

![Sekvenssikaavio2](https://github.com/ihamaki/paattipeli/blob/master/dokumentaatio/sekvenssi2.png)
