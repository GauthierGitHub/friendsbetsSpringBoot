import { IFriendsBetsModels } from './models-interfaces/IFriendsBetsModels';
import { Friend } from './Friend.model';

export class User extends Friend implements IFriendsBetsModels {

    readonly IS_MODEL: boolean = true;
    private _email: string;
    private _password: string;
    private _token: string;
    private _tokenLastUsed: Date;
    private _friends: Friend[];

    constructor();
    constructor(id: number, nickname: string, email: string, password: string, picturePath: string, token: string, tokenLastUsed: Date);
    constructor(id?: number);
    constructor(id?: number, nickname?: string, email?: string, password?: string);
    constructor(id?: number, nickname?: string, email?: string, password?: string, picturePath?: string, token?: string, tokenLastUsed?: Date) {
        super(id, nickname, picturePath)
        this._email = email ? email : undefined;
        this._password = password ? password : undefined;
        this._token = token ? token : "noToken"; // TODO: other initialization ?
        this._tokenLastUsed = tokenLastUsed ? tokenLastUsed : undefined;
    }

    get email(): string {
        return this._email;
    }
    set email(email: string) {
        this._email = email;
    }

    get password(): string {
        return this._password;
    }
    set password(password: string) {
        this._password = password;
    }

    get token(): string {
        return this._token;
    }
    set token(token: string) {
        this._token = token;
    }

    get tokenLastUsed(): Date {
        return this._tokenLastUsed;
    }
    set tokenLastUsed(_tokenLastUsed: Date) {
        this._tokenLastUsed = _tokenLastUsed;
    }

    get friends(): Friend[] {
        return this._friends;
    }
    set friends(_friends: Friend[]) {
        this._friends = _friends;
    }

}