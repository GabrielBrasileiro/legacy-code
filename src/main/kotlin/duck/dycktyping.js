class IntCalculator {
  constructor() {
    this.tax = 10
  }

  getTotal(value) {
    return value * this.tax
  }
}

class FloatCalculator {

  constructor() {
    this.tax = 10.0
  }

  getTotal(value) {
    const total = value * this.tax
    return `${total}`
  }
}

function calculate(calculator) {
  const total = calculator.getTotal(10)
  const addOne = total + 1

  console.log(addOne)
}

const intCalculator = new IntCalculator();
const floatCalculator = new FloatCalculator();

calculate(intCalculator)
calculate(floatCalculator)