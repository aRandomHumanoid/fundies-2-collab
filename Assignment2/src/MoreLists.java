interface ILoString {
  ILoString reverse();
  ILoString normalize();
  ILoString normalizeHelp(ILoString acc);
  ILoString scanConcat();
  ILoString scanConcatHelp(String acc);
}

class MtLoString implements ILoString {

  public ILoString reverse() {
    return this;
  }

  public ILoString normalize() {
    return this;
  }

  public ILoString normalizeHelp(ILoString acc) {
    return acc;
  }

  public ILoString scanConcat() {
    return this;
  }

  public ILoString scanConcatHelp(String acc) {
    return this;
  }
}

class ConsLoString implements ILoString {
  String first;
  ILoString rest;

  ConsLoString(String first, ILoString rest) {
    this.first = first;
    this.rest = rest;
  }

  public ILoString reverse() {
    return new SnocLoString (this.rest.reverse(), this.first);
  }

  public ILoString normalize() {
    return new ConsLoString(this.first, this.rest.normalize());
  }

  public ILoString normalizeHelp(ILoString acc) {
    return new ConsLoString(this.first, this.rest.normalizeHelp(acc));
  }

  public ILoString scanConcat() {
    return new ConsLoString(this.first, this.rest.scanConcatHelp(this.first));
  }

  public ILoString scanConcatHelp(String acc) {
    return new ConsLoString(acc + this.first, this.rest.scanConcatHelp(acc + this.first));
  }

}

class SnocLoString implements ILoString {
  ILoString rest;
  String last;

  SnocLoString(ILoString rest, String last) {
    this.rest = rest;
    this.last = last;
  }

  public ILoString reverse() {
    return new ConsLoString(this.last, this.rest.reverse());
  }

  public ILoString normalize() {
    return this.rest.normalizeHelp(new ConsLoString(this.last, new MtLoString()));
  }

  public ILoString normalizeHelp(ILoString acc) {//adds last to the cons of rest
    return this.rest.normalizeHelp(new ConsLoString(this.last, acc));
  }

  public ILoString scanConcat() {
    return this.normalize().scanConcat();
  }

  public ILoString scanConcatHelp(String acc) {
    return this.normalize().scanConcatHelp(acc);
  }

}

class AppendLoString implements ILoString {
  ILoString first;
  ILoString second;

  AppendLoString(ILoString first, ILoString second) {
    this.first = first;
    this.second = second;
  }
  public ILoString reverse() {
    return new AppendLoString(this.second.reverse(), this.first.reverse());
  }
  public ILoString normalize() {
    return this.first.normalizeHelp(this.second);
  }
  public ILoString normalizeHelp(ILoString acc) {
    return this.first.normalizeHelp(this.second.normalizeHelp(acc));
  }

  public ILoString scanConcat() {
    return this.normalize().scanConcat();
  }

  public ILoString scanConcatHelp(String acc) {
    return this.normalize().scanConcatHelp(acc);
  }
}