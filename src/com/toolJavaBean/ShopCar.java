package com.toolJavaBean;

import java.util.ArrayList;

import com.valJavaBean.GoodsSingle;

public class ShopCar {
	private ArrayList buylist=new ArrayList();			//�����洢�������Ʒ
	public ArrayList getBuylist() {
		return buylist;
	}
	/**
	 * @���� ���ﳵ��������Ʒ
	 * @���� singleΪGoodsSingle����󣬷�װ��Ҫ���ӵ���Ʒ��Ϣ
	 */
	public void addItem(GoodsSingle single){
		if(single!=null){
			if(buylist.size()==0){						//���buylist�в������κ���Ʒ
				GoodsSingle temp=new GoodsSingle();
				temp.setName(single.getName());
				temp.setPrice(single.getPrice());
				temp.setNum(single.getNum());
				buylist.add(temp);						//�洢��Ʒ
			}
			else{										//���buylist�д�����Ʒ	
				int i=0;				
				for(;i<buylist.size();i++){				//����buylist���϶����жϸü������Ƿ��Ѿ����ڵ�ǰҪ���ӵ���Ʒ		
					GoodsSingle temp=(GoodsSingle)buylist.get(i);		//��ȡbuylist�����е�ǰԪ��		
					if(temp.getName().equals(single.getName())){		//�жϴ�buylist�����л�ȡ�ĵ�ǰ��Ʒ�������Ƿ���Ҫ���ӵ���Ʒ��������ͬ
						//�����ͬ��˵���Ѿ������˸���Ʒ��ֻ��Ҫ����Ʒ�Ĺ���������1
						temp.setNum(temp.getNum()+1);					//����Ʒ����������1
						break;											//����forѭ��
					}
				}
				if(i>=buylist.size()){					//˵��buylist�в�����Ҫ���ӵ���Ʒ
					GoodsSingle temp=new GoodsSingle();
					temp.setName(single.getName());
					temp.setPrice(single.getPrice());
					temp.setNum(single.getNum());
					buylist.add(temp);					//�洢��Ʒ
				}
			}
		}			
	}
	/**
	 * @���� �ӹ��ﳵ���Ƴ�ָ�����Ƶ���Ʒ
	 * @���� name��ʾ��Ʒ����
	 */
	public void removeItem(String name){
		for(int i=0;i<buylist.size();i++){					//����buylist���ϣ�����ָ�����Ƶ���Ʒ
			GoodsSingle temp=(GoodsSingle)buylist.get(i);   //��ȡ�����е�ǰλ�õ���Ʒ
			//�����Ʒ������Ϊname����ָ��������
			if(temp.getName().equals(MyTools.toChinese(name))){							
				if(temp.getNum()>1){						//�����Ʒ�Ĺ�����������1
					temp.setNum(temp.getNum()-1);			//�򽫹���������1
					break;				         			//����forѭ��
				}
				else if(temp.getNum()==1){					//�����Ʒ�Ĺ�������Ϊ1
					buylist.remove(i);		   				//��buylist���϶������Ƴ�����Ʒ
				}
			}
		}
	}
	/**
	 * @���� ��չ��ﳵ
	 */
	public void clearCar(){
		buylist.clear();									//���buylist���϶���
	}
}