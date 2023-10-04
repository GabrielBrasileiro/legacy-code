class Bank {

    withdraw(value: number) {
        const balance = this.getBalance()

        if (value <= balance) {
            console.log("Sucesso no saque")
        } else {
            console.log("Erro no saque")
        }
    }

    private getBalance() {
        // External world
        return 1000.0
    }
}

const bank = new Bank()
bank.withdraw(500)