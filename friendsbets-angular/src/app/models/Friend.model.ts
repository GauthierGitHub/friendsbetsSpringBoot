import { IFriendsBetsModels } from './models-interfaces/IFriendsBetsModels';

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

    get id(): number {
        return this._id;
    }
    set id(id: number) {
        this._id = id;
    }

    get nickname(): string {
        return this._nickname;
    }
    set nickname(nickname: string) {
        this._nickname = nickname;
    }

    get picturePath(): string {
        return this._picturePath;
    }
    set picturePath(_picturePath: string) {
        this._picturePath = _picturePath;
    }
}