class NewInfo {
  constructor(readonly name: String) {}
}

interface LegacyStrategy {
  getName(): NewInfo;
}

class HardWorkClazz {
  private legacyName = 'legacy';

  getStrategy(): LegacyStrategy {
    return {
      getName: () => new NewInfo(this.legacyName),
    };
  }
}

class ProcessInfo {
  startNewScope(legacyStrategy: LegacyStrategy) {
    const name = legacyStrategy.getName();
    console.log(name);
  }
}

const hardWork = new HardWorkClazz();
const processInfo = new ProcessInfo();

processInfo.startNewScope(hardWork.getStrategy());

https://playcode.io/typescript