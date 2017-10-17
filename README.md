CeneoHD - Projekt. Proces ETL

1. Stwórz aplikację, która pozwoli na przeprowadzenie procesu ETL na który składa
się:
    a. pozyskanie danych ze źródeł zewnętrznych,
    b. poddanie danych odpowiednim przekształceniom,
    c. zasilenie danymi bazy danych.
2. Celem działania aplikacji będzie pobranie z serwisu Ceneo.pl wszystkich opinii o
produkcie, którego kod zostanie podany jako parametr. Dla uproszczenia
działanie aplikacji można ograniczyć do produktów z działów Komputery,
Fotografia oraz Telefony i akcesoria.
3. Dla każdej opinii należy pobrać:
    a. Wady produktu
    b. Zalety produktu
    c. Podsumowanie opinii
    d. Liczba gwiazdek
    e. Autor opinii (jeśli brakuje, to np. anonim)
    f. Data wystawienia opinii
    g. POLECAM / NIE POLECAM
    h. Ile osób uznało opinię za przydatną, a ile za nieprzydatną
W przypadku, gdy brakuje którejś wartości pole w tabeli należy pozostawić
puste.
4. Dla każdego produktu należy przechować w bazie danych:
    a. Rodzaj urządzenia
    b. Markę
    c. Model
    d. Dodatkowe uwagi 

1. Zadanie składa się z trzech części:
a. Aplikacji
b. Dokumentacji technicznej
c. Dokumentacji użytkownika 

2. Aplikację należy stworzyć w dowolnej, wybranej przez siebie technologii. Podobnie
bazę danych.
3. Jeśli aplikacja ma formę aplikacji webowej należy umieścić ją na dowolnym
serwerze (może to być serwer v-ie) tak, aby możliwy był do niej dostęp przez
przeglądarkę internetową.
4. W przypadku aplikacji w innej formie niż webowa należy określić minimalne
wymagania potrzebne do zainstalowania/uruchomienia aplikacji (środowisko,
biblioteki itp.)
5. Aplikacja powinna mieć możliwość przeprowadzenia całego procesu ETL na raz
(np. przycisk ETL) jak również przeprowadzenia każdej jego części oddzielnie –
jedna po drugiej (np. trzy kolejne przyciski E, T, L).
6. W przypadku wykonywania procesu ETL etapami wykonanie kolejnego etapu
powinno być możliwe tylko po uprzednim wykonaniu wcześniejszego etapu (np.
nie powinno się dać wykonać operacji Transform, jeśli wcześniej nie została
wykonana operacja Extract).
7. Po przeprowadzeniu pełnego procesu ETL lub ostatniego etapu Load produkty
uboczne procesu (np. pobrane pliki) powinny być usuwane (tym samym po
wykonaniu Load nie powinno być możliwości wykonania operacji Transform bez
ponownego wykonania Extract).
8. Po przeprowadzeniu pełnego procesu ETL jak również po każdej z jego
składowych powinny być wyświetlane informacje statystyczne np. ile plików
zostało pobranych, ile rekordów zostało załadowanych do bazy danych.
9. Dane w bazie nie powinny się dublować – jeśli dana opinia zastała dodana do
bazy przy poprzednim uruchomieniu procesu ETL nie powinna zostać dodana
przy kolejnych. Podobnie w przypadku produktów.
10. Aplikacja powinna mieć przycisk pozwalający na wyczyszczenie w bazie danych
dotyczących opinii tak, aby możliwe było zaobserwowanie procesu zasilenia bazy
opiniami.
11. Aplikacja powinna umożliwiać wyświetlenie opinii z bazy w podziale na produkty,
których opinie dotyczą.
12. Dodatkowo aplikacja powinna mieć możliwość eksportu danych do pliku .csv
(osobny przycisk lub opcja) i oddzielnych plików tekstowych dla każdej opinii
13. Projekt powinien być uniwersalny – powinien nadal działać, gdy na stronie
zostaną dodane nowe opinie lub jakaś opinia zostanie usunięta. 
15. Projekt powinien zawierać dokumentację techniczną (traktowaną jako opis API),
która może być napisana podobnie do dokumentacji klas bibliotek Javy1
.
16. Dokumentacja techniczna powinna zawierać:
a. Nazwy i wersje użytych technologii (języki programowania, sposób
przechowywania danych).
b. Projekt fizyczny bazy danych wykorzystanej w projekcie.
c. Informacje na temat środowiska, wymaganego do uruchomienia programu.
d. Linki do oprogramowania, które to środowisko tworzą.
e. (jeśli obiektowo) nazwy klas, tabelkę z listą i opisem atrybutów, tabelkę z
listą i opisem (wartość zwracana, przyjmowane parametry, opis działania)
funkcji składowych (z konstruktorami i destruktorami włącznie);
f. (jeśli strukturalnie): tabelkę z listą i opisem zmiennych, tabelkę z listą i
opisem (wartość zwracana, przyjmowane parametry, opis działania)
funkcji.
17. Ponadto projekt powinien zawierać dokumentację użytkownika – instrukcje
obsługi programu przedstawiającą krok po kroku (najlepiej ze zrzutami ekranu)
jak z aplikacji korzystać począwszy od jej „instalacji” (sposobu uruchomienia) aż
do wyświetlenia danych z bazy pobranych w trakcie działania aplikacji 

1. Przez platformę e-learningową należy przesłać:
a. Link do publicznego repozytorium Git z kodem aplikacji!
b. Źródło danych określające strukturę przechowywanych danych wraz z
przykładowymi danymi (np. kod SQL)
c. Link do aplikacji jeśli ma ona postać aplikacji webowej
d. Link do dokumentacji technicznej lub jej kod jeśli ma ona postać aplikacji
e. Dokumentację techniczną oraz dokumentację użytkownika złożone w jeden
spójny dokument tekstowy
2. Jako stronę tytułową dokumentacji wykorzystaj plik dostępny na platformie elearningowej.
Wypełnij tabelkę danymi członków zespołu. Podaj za jakie
czynności odpowiadał każdy członek zespołu.
3. Plikowi z dokumentacjami nadaj nazwę według wzoru: NumerGrupyProjektowej
_Projekt.[doc|docx]
4. Prześlij pliki i linki przez platformę e-learningową w terminie wskazanych we
właściwym zadaniu (aktywności). Wystarczy jeśli jedna osoba z grupy prześle
pliki projektu.
5. Wydrukowany dokument z instrukcjami przynieś na konsultacje na których
zespół będzie prezentował i zaliczał projekt. 


