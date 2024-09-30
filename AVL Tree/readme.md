# Implementacja drzewa AVL na przykładzie „Liczby rzeczywiste”
Napisać program do zarządzania zbiorem liczb rzeczywistych nieujemnych (maksymalnie 8 cyfr
dziesiętnych przed i po przecinku). Program ma umożliwiać szybkie wykonywanie następujących
operacji:

- wstawienie do zbioru nowej liczby
- usunięcie ze zbioru zadanej liczby
- wyszukanie w zbiorze danej liczby
- znalezienie liczby liczb, których część całkowita jest równa zadanej przez użytkownika liczbie
- wyświetlenie struktury drzewa wraz z elementami
- wykonanie skryptu poleceń:
   - W x – wstaw x
   - U x – usuń x
   - S x – szukaj x (odpowiedź: TAK/NIE)
   - L x – wypisać, ile liczb posiada część całkowitą równą x

## Przykład
### Plik wejściowy:

```
5 //liczba poleceń 
W 1,6 //wstaw liczbę 1,5 
W 1,8 //wstaw liczbę 1,8
S 2,5 //szukaj liczby 2,5
W 2,1 //wstaw liczbę 2,1
U 1,6 //usuń liczbę 1,6
L 2 //ile liczb posiada część całkowitą 2 

```
### Plik wyjściowy:
```
NIE //liczba 2,5 nie występuje w drzewie
1 //1 liczba posiada część całkowitą 2
```
