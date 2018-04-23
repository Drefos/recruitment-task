# recruitment-task
Instrukcja przygotowania oraz przetestowania aplikacji.

Na początku należy utworzyć nową bazę danych MySQL o nazwie `company`.

Po pobraniu repozytorium zaimportować lub otworzyć za pomocą IDE.
Korzystając z IntelliJ Ultimate IDE:
1. W widoku powitalnym wybrać opcję „Open” i wskazać główny folder aplikacji pobranej z repozytorium
2. Przejść do pliku „application.properties” w folderze resources i zmienić nazwę użytkownika oraz hasło do bazy danych
3. Przejść do klasy zawierającą metodę main (klasa RecruitmentTaskApplication)
4. Uruchomić projekt zielonym trójkącikiem po lewo od nazwy klasy lub skrótem klawiaturowym (crtl+shift+R na Mac OS lub ctrl+shift+F10 Win/Linux)

Korzystając z Spring Tool Suite:
1. Po uruchomieniu STS w menu File wybrać opcję Import
2. Wybrać jako Maven -> Existing Maven Projects
3. W następnym widoku wskazać główny folder aplikacji pobranej z repozytorium
4. Przejść do pliku „application.properties” w folderze resources i zmienić nazwę użytkownika oraz hasło do bazy danych
5. Prawym przyciskiem na klasie RecruitmentTaskApplication, po kliknięciu wybrać Run as -> Spring Boot App

Następnie w celu wywołania usług REST’owych uruchomić program typu Rest Client (np. CocoaRestClient na MAC OS lub wtyczka HttpRequester dla przeglądarki mozilla). 


**`Żądania GET`**

Aplikacja działa pod adresem: http://localhost:8080/api.
Dla wygody testowania można załadować przykładowe dane, aby to zrobić trzeba wywołać adres: http://localhost:8080/api/loadCustomData.

Pod adresem http://localhost:8080/api/employees dostępna jest lista wszystkich pracowników z domyślnym filtrowaniem po imieniu. Aby zmienić filtrowanie listy należy dodać w żądaniu parametr „orderBy” z jedną z wartości [firstName, lastName, email].
Do pojedynczego pracownika można odwołać się poprzez dodanie w adresie nr id użytkownika np. adres http://localhost:8080/api/employees/1 zwróci pracownika o id=1.

W celu otrzymania listy stanowisk z liczbą przypisanych pracowników należy odwołać się do adresu http://localhost:8080/api/positions.


**`Żądanie POST`**

W celu dodania nowego użytkownika do listy należy odwołać się do adresu http://localhost:8080/api/employees uprzednio dodając nagłówek „Content-Type” z wartością „application/json” oraz ciało żądania w formacie JSON np.
```
{
  "firstName": "Steve",
  "lastName": "Darcey",
  "email": "zivsteve@darcey.com",
  "position": "TESTER"
}
```


**`Żądanie PUT`**

Edycja danych pracownika odbywa się podobnie do tworzenia nowego pracownika. Jeżeli nasz wcześniej dodany Steve zmienia stanowisko na developera należy odwołać się do adresu http://localhost:8080/api/employees/13 (gdzie 13 to id naszego pracownika) dodając nagłówek „Content-Type” z wartością „application/json” oraz ciało żądania w formacie JSON.
```
{
  "firstName": "Steve",
  "lastName": "Darcey",
  "email": "zivsteve@darcey.com",
  "position": "DEV"
}
```


**`Żądanie DELETE`**

Usuwanie użytkownika polega na odwołaniu się do adresu posiadającego id użytkownika który ma zostać usunięty np. odwołanie się do adresu http://localhost:8080/api/employees/2 spowoduje usunięcie użytkownika o id=2.
