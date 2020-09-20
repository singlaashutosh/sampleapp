import { Moment } from 'moment';
import { TransType } from 'app/shared/model/enumerations/trans-type.model';

export interface ITransactionEntity {
  id?: number;
  transAmmount?: number;
  transDate?: Moment;
  transType?: TransType;
  entryDate?: Moment;
  accountEntityCode?: string;
  accountEntityId?: number;
}

export class TransactionEntity implements ITransactionEntity {
  constructor(
    public id?: number,
    public transAmmount?: number,
    public transDate?: Moment,
    public transType?: TransType,
    public entryDate?: Moment,
    public accountEntityCode?: string,
    public accountEntityId?: number
  ) {}
}
