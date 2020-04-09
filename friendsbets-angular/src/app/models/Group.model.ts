import { IFriendsBetsModels } from './models-interfaces/IFriendsBetsModels';
import { Friend } from './Friend.model';

export class Group implements IFriendsBetsModels {
    
    readonly IS_MODEL: boolean = true;
    private _id: number;
    private _name: string;
    private _friends: Friend[];
    // TODO: replace string by models
    private _bets: string[];
    private _groupMessages: string[];
    private _picturePath: string;


    constructor();
    constructor(id: number, name: string);
    constructor(id?: number);
    constructor(id?: number, name?: string) {
        this._id = id ? id : 0;
        this._name = name ? name : undefined;
    }

    get id(): number {
        return this._id;
    }
    set id(_id: number) {
        this._id = _id;
    }

    get name(): string {
        return this._name;
    }
    set name(_name: string){
        this._name = _name;
    }

    get friends(): Friend[] {
        return this._friends;
    }
    set friends(friends: Friend[]){
        this._friends = friends;
    }

    get bets(): string[] {
        return this._bets;
    }
    set bets(_bets: string[]){
        this._bets = _bets;
    }

    get groupMessages(): string[] {
        return this._groupMessages;
    }
    set groupMessages(_groupMessages: string[]){
        this._groupMessages = _groupMessages;
    }

    get picturePath(): string {
        return this._picturePath;
    }
    set picturePath(_picturePath: string) {
        this._picturePath = _picturePath;
    }
}