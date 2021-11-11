# contracts

## Configuration
Before you start working you needed:
- git client
- maven 
- jdk 1.8
- A Java IDE of your choice (not mandatory)
- chromedriver
- Selenium

## The tests were run in the following environment

- Hardware: MacBook Pro (2.6 Ghz Intel Core I7, 16GB DDR3).
- SO: Mac OS Big Sur
- Google Chrome 96
- Safari 15.1

_execution times could change_

## Setup
In order to get the code:

- Create a folder (Windows): 
```
md d:\Contracts
cd d:\Contracts
git clone https://github.com/luisgosmx/contracts.git
cd contracts
```
- Compile everything
```
mvn clean install
```
If you don't want to download the entire repository, just havevest.jar and run it in the console.


## Run the harvest

## NEWS

 **command**
 
 `java -jar harvester.jar -newsharvest -namesource XXXX -output XXXX`
  outpot is the folder where they will be saved

**Ways to get information**
 - **RSS** (Really Simple Syndication) XML format to distribute content on the web.

**newspapers available**

- Reforma (México)  https://www.reforma.com   **_RSS_**            `-namesource reforma`
- El Universal (México) https://www.eluniversal.com.mx   **_Web scraping_**       `-namesource eluniversal`

**Example Reforma
```
{
    "news": {
        "creator": "Érika Hernández",
        "date_harvest": "10-11-2021T17:50:1",
        "publication_date": "Wed, 10 Nov 2021 16:49:54 -0600",
        "id": "REF1011202117501",
        "source": "http:\/\/www.reforma.com\/aplaza-ine-consulta-por-revocacion-hasta-el-10-de-abril\/ar2294810",
        "text": "INE aplazó del 27 de marzo al 10 de abril la fecha para la consulta de revocación de mandato, al requerir mayor tiempo para procesar firmas.",
        "title": "Aplaza INE consulta por revocación hasta el 10 de abril",
        "category": "84"
    }
}
```

**Example El Universal 
```

{
    "news": {
        "keywords": "Joe Biden, EU, Brandon Brown, vamos brandon",
        "date_harvest": "10-11-2021T17:49:38",
        "publication_date": "10\/11\/2021",
        "id": "UNI10112021174938",
        "source": "https:\/\/www.eluniversal.com.mx\/mundo\/eu-por-que-comenzaron-usar-vamos-brandon-para-mandar-al-infierno-joe-biden",
        "text": "Es un dicho hostil que se ha esparcido por Estados Unidos en menos de seis semanas y se puede ver en gorras o en carteles en los estadios, e incluso llegó al Congreso en Washington: casi ningún estadounidense ignora que \"Let's Go Brandon\" significa realmente \"Fuck You Biden\". La rapidez con la que esta frase se ha difundido en un país ultra polarizado ilustra el deterioro del debate político tras la era Donald Trump y refleja también la caída de la popularidad de Joe Biden, su sucesor en la Casa Blanca. ¿De dónde vienen estas tres palabras? Todo comenzó con una simple entrevista televisiva el pasado 2 de octubre con el corredor automovilístico Brandon Brown. Tras salir victorioso en una competencia del circuito Nascar, el piloto de 28 años contestaba las preguntas de una reportera cuando se comenzó a escuchar un cántico entre la multitud. Elevando el tono de voz para cubrir el ruido de las tribunas, la entrevistadora dijo: \"Pueden escuchar los cánticos de la multitud: Let's go Brandon! (¡Vamos, Brandon!)\". Cuando claramente se escucha que las personas gritaban: \"Fuck Joe Biden! (Vete a la mierda, Biden)\". El error de la reportera, combinado con la alegría de Brandon, fue suficiente para que la secuencia se hiciera viral. Y el dicho \"Let's Go Brandon\" se convirtió en una forma fácil y edulcorada de mandar a Biden al infierno, sin repetir la llamada \"F. word\", una palabra grosera y proscrita de cualquier discurso educado. Entonces, en las últimas semanas incluso responsables políticos republicanos han retomado la fórmula, suscitando las críticas del campo demócrata. AMLO, dispuesto a responder a Biden sobre la Reforma Eléctrica: \u201CEs que no quieren dejar de robar\u201D\" Entre ellos, el muy trumpista gobernador de Florida, Ron DeSantis, que algunos ven como candidato a la Casa Blanca en 2024. En un discurso en West Palm Beach, localidad en la que Trump disfruta de su retiro en su lujoso club de Mar-A-Lago, DeSantis se refirió a la \"administración Brandon\". Y así le allanó el camino a otros republicanos, que hicieron que el dicho saliera de los círculos de extrema derecha y se difundiera, tomando de cierta manera un aire de aceptabilidad. Jeff Duncan, legislador de Carolina del Sur, causó revuelo al mostrarse con una mascarilla con el eslogan \"Let's Go Brandon\" en la Cámara de Representantes. El gobernador de Texas, Greg Abbott, tuiteó la frase y el senador Ted Cruz, otro peso pesado republicano, posó con una pancarta de \"Let's Go Brandon\". Entre los seguidores de Trump, las camisetas de \"Let's Go Brandon\" se ven en todas las tallas y colores, incluso sobre el fondo de la bandera estadounidense. Al finalizar un vuelo de Houston a Albuquerque, un piloto de Southwest Airlines repitió las palabras durante un mensaje a la cabina. Tildándolo de conducta \"inaceptable\", la compañía aérea inició luego una investigación interna. Foto: AFP Las autoridades deportivas, especialmente las universitarias, han visto el fenómeno con preocupación. El eslogan es retomado por las multitudes en muchos estadios y otros lugares de competición en Estados Unidos, en particular en el circuito Nascar, conocido por atraer un público mayoritariamente blanco y de clase trabajadora. El viernes, el jefe de Nascar, Steve Phelps, advirtió que su organización no toleraría más ver su logo asociado con el insulto. Y el sábado en la noche, el eslogan volvió a tomar gran notoriedad cuando hizo una entrada estelar en el canal de YouTube de Saturday Night Live, el conocido programa de sátira política. Del lado de los partidarios del presidente Biden, la respuesta ha tomado un giro irónico, con la etiqueta #ThankYouBrandon (\"Gracias Brandon\"). También lee: Mujer se vuelve millonaria en Australia solo por vacunarse contra Covid-19 ed",
        "title": "¿Por qué en EU comenzaron a usar \u201C¡Vamos, Brandon!\u201D para \u201Cmandar al infierno\u201D a Biden? La rapidez con la que esta frase se ha difundido en un país ultra polarizado ilustra el deterioro del debate político tras la era Donald Trump y refleja también la caída de la popularidad de Joe Biden Foto: AFP Mundo 10\/11\/2021 12:17 AFP Actualizada 12:37 Guardando favorito..."
    }
}
```

## DEFAULTER

**command**
 
 `java -jar harvester.jar -defaulterharvest -name "XXXX" -namesource sancionesmx -os XXXX -output XXXX`
 
 
**Available pages**

- Sanciones https://sanciones.cnbv.gob.mx

**Example Sanciones
```
    {
    "defaulter": {
        "datesanction": "24\/06\/2014",
        "subsector": "Sociedades operadoras de sociedades de inversión de renta variable e instrumentos de deuda",
        "sanction": "En séis ocasiones presentó reportes contables que no contaban con la calidad y las caracteristicas exigibles.",
        "name": "IMPULSORA DE FONDOS BANAMEX, S.A. DE C.V., SOCIEDAD OPERADORA DE FONDOS DE INVERSIÓN, INTEGRANTE DEL GRUPO FINANCIERO BANAMEX",
        "penalty_fee": "$0.00",
        "company": "banamex",
        "id": "SMX1011202117270",
        "type": "Amonestación"
    }
}
```
