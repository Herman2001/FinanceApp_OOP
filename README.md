# FinanceApp OOP

---

## Funktioner

- Lägg till, uppdatera och ta bort transaktioner (inkomster och utgifter)
- Lista alla transaktioner
- Filtrera transaktioner efter år, månad, vecka eller dag
- Visa saldo, total inkomst och utgifter
- Alla data sparas till en CSV-fil

---

## Struktur

- **Command**: Terminal-kommandon hanteras via Command Pattern, vilket gör det enkelt att lägga till nya funktioner och separera användarinteraktion från logik.
- **Service**: Affärslogik för transaktioner, inklusive summering, filtrering och uppdatering.
- **Repository**: Abstraktion för datalagring (Memory + CSV) som möjliggör enkel utbytbart sparande, t.ex. mot databas i framtiden.
- **Model**: `Transaction` som representerar varje transaktion.
- **Util**: Hjälpklasser för input och validering.

---
