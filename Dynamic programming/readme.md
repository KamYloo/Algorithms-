# Programowowanie dynamiczne na przykładzie problemu Górski hotel
Pewna alpejska miejscowość jest znana ze swojego położenia w otoczeniu wspaniałych gór. Turyści
z całego świata przyjeżdżają podziwiać tutaj pionowy świat pełen skalnych ścian i wodospadów.
Można tam spotkać przedstawicieli różnych narodowości: od Amerykanów po wyjątkowo licznych
Chińczyków. Pewien mały okoliczny hotelik (dysponujący dwoma apartamentami) ma wyjątkowe
powodzenie wśród przyjezdnych – położony jest on nad samą przepaścią, a z jego okien otwierają
się bajkowe widoki. Mimo wielkich cen nie brakuje chętnych na noclegi i wschód słońca z
widokiem na białe szczyty. Ze względu na dużą popularność miejsca na świecie właściciele hotelu
postanowili zmienić strategie rezerwacji i maksymalnie zwiększyć swoje zyski (góry górami, ale
kasa musi się zgadzać). Hotel przyjmuje rezerwacje od gości z dużym wyprzedzeniem, ale bez
ustalonej ceny – każdy deklaruje ile jest w stanie zapłacić za pobyt w deklarowanym okresie. Po
zebraniu zgłoszeń właściciele hotelu sami decydują, komu przyznać pokoje – kryterium jest
oczywiście jak największy zysk. Okazało się jednak, że rezerwacji jest tyle, że bez pomocy
komputera zadanie wyselekcjonowania najlepszych zgłoszeń jest niemożliwe. Zdenerwowany
właściciel (a miało być tak pięknie!) pilnie poszukuje informatyka, który przygotuje odpowiednie
oprogramowanie. Za usługę na pewno zapłaci hojnie (po szwajcarsku). Wiadomo, że pojedyncza
rezerwacja zawsze obejmuje jeden apartament na zadany okres czasu. Dwóch rezerwacji nie można
przydzielić do tego samego apartamentu jeżeli zachodzą na siebie terminami. Ponadto, koniec
rezerwacji apartamentu w danym dniu oznacza, że od tego dnia można tam przyjmować gości w
ramach kolejnej rezerwacji. Pomóż zarobić hotelowi jak najwięcej, a nie pożałujesz.

## Wejście:
W pierwszej linii wejścia pojawia się liczba całkowita n (1<=n<300) oznaczająca liczbę rezerwacji.
W kolejnych n liniach podane są informacje o kolejnych rezerwacjach: w każdej linii po trzy liczby
całkowite p, k oraz z oddzielone spacjami (1<=p<=300, p<k<=300, 1<=z<=1000) oznaczające
odpowiednio dzień początku rezerwacji, dzień końca rezerwacji oraz zysk z tej rezerwacji.
UWAGA: Na wejściu nie istnieje taka para rezerwacji, która kończy się tego samego dnia.

## Wyjście:
W jedynym wierszu wyjścia ma się pojawić jedna liczba całkowita oznaczająca maksymalny
przychód jaki hotel może uzyskać z realizacji rezerwacji.

## Przykład
### Wejście
```
5 //5 rezerwacji
9 11 2 //pierwsza rezerwacja od dnia 9 do dnia 11 (zapłata 2)
1 5 4
1 8 7
5 9 4
6 10 5
```

### Wyjście
```
18 //zysk 18 (apartament nr 1: rezerwacje nr 1 i 3, apartament nr 2: rezerwacje nr 2 i 5)
```
