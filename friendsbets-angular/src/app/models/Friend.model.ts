import { IFriendsBetsModels } from './models-interfaces/IFriendsBetsModels';
import { User } from './User.model';

export class Friend implements IFriendsBetsModels {

    readonly IS_MODEL: boolean = true;
    private _id: number;
    private _nickname: string;
    private _picturePath: string;

    constructor();
    constructor(id: number, nickname: string, picturePath: string);
    constructor(id?: number);
    constructor(id?: number, nickname?: string, picturePath?: string) {
        this._id = id ? id : 0;
        this._nickname = nickname ? nickname : undefined;
        this._picturePath = picturePath ? picturePath : undefined;
    }

    public toUser(): User {
        return new User(this.id);
    }

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get nickname(): string {
        return this._nickname;
    }

    public set nickname(nickname: string) {
        this._nickname = nickname;
    }

    public get picturePath(): string {
        return this._picturePath;
    }

    public set picturePath(picturePath: string) {
        this._picturePath = picturePath;
    }

}