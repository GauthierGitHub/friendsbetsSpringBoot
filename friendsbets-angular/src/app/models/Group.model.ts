import { User } from './User.model';
import { IFriendsBetsModels } from './models-interfaces/IFriendsBetsModels';
import { Friend } from './Friend.model';

export class Group implements IFriendsBetsModels {
    
    // TODO: replace string by models ?
    readonly IS_MODEL: boolean = true;
    private _id: number;
    private _name: string;
    private _users: number[];
    private _friends: Friend[];
    private _bets: string[];
    private _messages: string[];
    private _picturePath: string;

    constructor();
    constructor(id: number, name: string);
    constructor(id?: number);
    constructor(id?: number, name?: string) {
        this._id = id ? id : 0;
        this._name = name ? name : undefined;
    }

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get name(): string {
        return this._name;
    }

    public set name(name: string) {
        this._name = name;
    }

    public get users(): number[] {
        return this._users;
    }

    public set users(users: number[]) {
        this._users = users;
    }

    public get friends(): Friend[] {
        return this._friends;
    }

    public set friends(friends: Friend[]) {
        this._friends = friends;
    }

    public get bets(): string[] {
        return this._bets;
    }

    public set bets(bets: string[]) {
        this._bets = bets;
    }

    public get messages(): string[] {
        return this._messages;
    }

    public set messages(messages: string[]) {
        this._messages = messages;
    }

    public get picturePath(): string {
        return this._picturePath;
    }

    public set picturePath(picturePath: string) {
        this._picturePath = picturePath;
    }


}