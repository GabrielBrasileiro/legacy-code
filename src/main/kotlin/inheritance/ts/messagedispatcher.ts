class MessageDispatcherLegacy {
  private static readonly colon = ":"
  private readonly key = "identifier"

  public processMessage(contentMessage: string): void {
    const allMessage = this.getKey() + MessageDispatcherLegacy.colon + contentMessage
    const transformed = allMessage.toUpperCase()

    this.dispatchMessage(transformed);
  }

  protected dispatchMessage(message: string): void {
    console.log(message)
    // Local code that connects to the external world.
  }

  protected getKey(): string {
    return this.key
  }
}

class MessageDispatcherFake extends MessageDispatcherLegacy {

  private readonly customKey: string;
  private lastMessage: string | undefined;

  constructor(customKey: string) {
    super();
    this.customKey = customKey
  }

  protected dispatchMessage(message: string): void {
    this.lastMessage = message
  }

  protected getKey(): string {
    return this.customKey
  }

  public getLastMessage(): string | undefined {
    return this.lastMessage
  }
}

