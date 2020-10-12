#include <iostream.h>
#include <conio.h>
#include <stdio.h>
#include <iomanip.h>
#include <dos.h>
#include <stdio.h>
#include <string.h>
#define MAX 100
void start();
void load_bar();
void head();
void mainscreen();
void side_line();
class med_store                           //CLASSS 1.
{
	private:
		char med_name[30];
		int qty,i;
		float price,tot_amt;

	public:

		void ip(void);
		void op(void);
		float cal_tot_amt(void);
		float sum_tot_amt(void)
		{
			return(tot_amt);
		}

};
class name					//CLASS 2.
{
	private:
		char name[20];
		int age;
	public:
		void ip1(void);
		void op1(void);

};
class stock					//CLASS 4 for Constructors.
{
	private:
		char name[20],name2[20];
		int qty,ddM,mmM,yyM,ddE,mmE,yyE;
	public:

	      stock();
	      stock(char med[],int q,int dM,int mM,int yM,int dE,int mE,int yE)
	      {
			strcpy(name,med);
			qty=q;


			ddM=dM;
			mmM=mM;
			yyM=yM;

			ddE=dE;
			mmE=mE;
			yyE=yE;

	      }
	      stock(char med1[],float q,float dM,float mM,float yM,float dE,float mE,float yE)
	      {
			strcpy(name,med1);
			qty=q;

			ddM=dM;
			mmM=mM;
			yyM=yM;

			ddE=dE;
			mmE=mE;
			yyE=yE;
	      }
	      void showdata();
};
stock :: stock()
{
			strcpy(name,"SINAREST");
			qty=100;

			ddM=20;
			mmM=3;
			yyM=2017;

			ddE=23;
			mmE=6;
			yyE=2021;
}
void stock :: showdata()
{
	cout << " 		MEDICINE NAME 		: " << name << endl;
	cout << " 		QUANTITY      		: " << qty << endl;
	cout << " 		MANUFACTURING DATE      : " << ddM << "/" << mmM << "/" << yyM << endl;
	cout << " 		EXPIRY DATE	        : " << ddE << "/" << mmE << "/" << yyE << endl;
}
class stock1
{
	private:
		char name[20],name2[20];
		int qty,ddM,mmM,yyM,ddE,mmE,yyE;
	public:
		stock1();
		stock1(char N[],int Q, int DM, int MM, int YM, int DE, int ME, int YE)
		{
		 strcpy(name, N);
		 qty = Q;
		 ddM = DM;
		 mmM=MM;
		 yyM=YM;

		 ddE=DE;
		 mmE=ME;
		 yyE=YE;
		}
		stock1(char na[], int QTY,float DM, float MM, float YM, float DE, float ME,float YE)
		{
		strcpy(name2, na);
		 qty = QTY;
		 ddM = DM;
		 mmM= MM;
		 yyM= YM;

		 ddE= DE;
		 mmE= ME;
		 yyE= YE;

		}
		void show_data();

};
stock1 :: stock1()
{
			strcpy(name,"ATIVAN");
			qty=100;

			ddM=20;
			mmM=3;
			yyM=2017;

			ddE=23;
			mmE=6;
			yyE=2021;
}

void stock1 :: show_data()
{

	cout << " 		MEDICINE NAME 		: " << name << endl;
	cout << " 		QUANTITY      		: " << qty << endl;
	cout << " 		MANUFACTURING DATE      : " << ddM << "/" << mmM << "/" << yyM << endl;
	cout << " 		EXPIRY DATE 	        : " << ddE << "/" << mmE << "/" << yyE << endl;
}
void name :: ip1(void)
{
	cout << endl << " ENTER THE NAME: ";
	gets(name);
	cout << endl << " ENTER THE AGE: ";
	cin >> age;
}
void name :: op1(void)
{
	cout << endl << " DATE:- "<< __DATE__ << endl;
	cout << "\n --------------------------------------------------------------------------- ";
	cout << "\n COUSTMER  : " << name;
	cout << endl << " AGE      : " << age;
	cout << endl << " --------------------------------------------------------------------------- ";

}
void med_store ::ip(void)
{
	cout << endl << " ENTER THE MEDICINE NAME: ";
	gets(med_name);
	cout << endl << " ENTER THE QUANTITY: ";
	cin >> qty;
	cout << endl << " ENTER THE PRICE: ";
	cin >> price;

}
void med_store :: op(void)
{
	cout.setf(ios::left,ios::adjustfield);
	cout  << " " << setw(20) << med_name;
	cout.unsetf(ios::left);
	cout << setw(13) << qty << setw(17) << price << setw(16) << cal_tot_amt() << endl;

}
float med_store :: cal_tot_amt(void)
{
	tot_amt = qty * price;
	return(tot_amt);

}
void main()
{

	clrscr();
	textbackground(1);
	load_bar();

	name na;
	med_store med[MAX];
	stock s;
	stock sk("PARACITIMOL",100,20,2,2015,12,3,2020);
	stock sk1("XANEN",80,12,5,2019,1,1,2025);
	stock1 s1;
	stock1 skk("VICKS",200,20,3,2015,12,5,2019);
	stock1 skkk("BICOSULE",300,2,9,2018,1,7,2024);


	int choice;
	char ch;

	label1:
	mainscreen();
	head();

	gotoxy(30,10); textcolor(WHITE);
	cprintf("ENTER THE CORRESPONDING NO: ");
	gotoxy(30,12);
	cprintf("1.PURCHASE MEDICINE.");
	gotoxy(30,13);
	cprintf("2.STOCKS OF MEDICINE.");
	gotoxy(31,14);
	cprintf(" ");

	cin >> choice;
	switch(choice)
	{
		case 1:
		clrscr();
		textbackground(1);
		head();
		cout << endl;
		na.ip1();
		int i,n;
		cout << endl << " HOW MANY MEDICINE PURCHASED: ";
		cin >> n;
		clrscr();
		for(i=0;i<n;i++)
		{
			cout << " FOR MEDICINE " << i+1 << endl;
			med[i].ip();
			clrscr();
		}
		clrscr();

		head();

		na.op1();
		cout << "\n --------------------------------------------------------------------------- ";
		cout << "\n Medicine name\t\t\tQty\t\tPrice\t\tTotal";
		cout << endl << " ---------------------------------------------------------------------------\n";

		for(i=0;i<n;i++)
		{
			med[i].op();
		}
		cout << endl << " --------------------------------------------------------------------------- ";
		float tot_exp = 0;
		for(i=0;i<n;i++)
		{
			tot_exp = tot_exp + med[i].sum_tot_amt();

		}
		cout << "\n TOTAL PAYABLE AMOUNT: " << tot_exp;
		cout << endl << " --------------------------------------------------------------------------- ";
		getch();
		break;

		case 2:
		clrscr();

		cout << endl;
		cout << " STOCKS OF MEDICINE:-    " << endl;
		cout << endl;


		textbackground(1);

		cout << endl;
		cout << endl;
		s.showdata();
		cout << endl;

		sk.showdata();
		cout << endl;

		sk1.showdata();
		cout << endl;
		side_line();
		getch();
		clrscr();

		cout << endl;

		cout << " STOCKS OF MEDICINE:-    " << endl;
		cout << endl;

		cout << endl;
		cout << endl;
		s1.show_data();
		cout << endl;

		skk.show_data();
		cout << endl;

		skkk.show_data();
		side_line();
		getch();
		clrscr();
		break;

		default:
		cout << "NIL" << endl;
	}
	clrscr();
	textbackground(1);
	cout << "  Û";
	cout << "\nÜÜÛÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜ";
	gotoxy(3,3);
	cprintf("Û");
	cout << endl;
	cout << "\n DO YOU WANT TO DO THIS AGAIN. " << endl;
	cout << " _YES_ or _NO_ :  ";
	fflush(stdin);
	ch=getc(stdin);
	if(ch == 'Y' || ch == 'y')
	{
		clrscr();
		goto label1;
	}

	getch();
}
///ÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ
//FUNCTIONS DEFINTIONS
void start(void)
{
	int i1,j1;
	clrscr();
	for(i1=1,j1=1;i1<79;j1++)
	{
		if(j1>15)
		j1=2;
		textcolor(15);
		gotoxy(i1,2);
		cprintf("%c",220);
		gotoxy(i1,66);
		cprintf("%c",220);
		i1++;

	}
	for(i1=1,j1=1;i1<66;i1++,j1++)
	{
		if(j1>15)
		j1=2;
		textcolor(15);
		gotoxy(1,i1);
		cprintf("%c",220);
		gotoxy(79,i1);
		cprintf("%c",220);

	}


}
void load_bar()
{
	int i,j;
	clrscr();
	gotoxy(36,23);
	cprintf("LOADING.....");
	for(i=24;i<25;i++)
	{
		for(j=2;j<79;j++)
		{
			delay(30);
			gotoxy(j,i);
			cprintf("Ü");
		}
	}
}
void head()
{

	gotoxy(34,3);
	cprintf("ÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜ");
	gotoxy(34,4);
	cprintf("Ý");
	gotoxy(35,4);
	textcolor(14 + BLINK);
	cprintf("PAWAN MEDICAL");
	textcolor(WHITE);
	gotoxy(48,4);
	cprintf("Þ");
	gotoxy(34,5);
	cprintf("ßßßßßßßßßßßßßßß");
	/*
	gotoxy(29,2);
	cprintf("  ÕÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ¸");
	gotoxy(31,3);
	textcolor(WHITE);
	cprintf("³   PAWAN MEDICAL   ³");
	gotoxy(29,4);
	textcolor(WHITE);
	cprintf("  ÔÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ¾");
       */
}
void mainscreen()
{
	int i1,j1;
	clrscr();
	for(i1=1,j1=1;i1<79;j1++)
	{
		if(j1>15)
		j1=2;
		textcolor(15);
		gotoxy(i1,2);
		cprintf("%c",220);
		gotoxy(i1,66);
		cprintf("%c",220);
		i1++;

	}
	for(i1=1,j1=1;i1<66;i1++,j1++)
	{
		if(j1>15)
		j1=2;
		textcolor(15);
		gotoxy(1,i1);
		cprintf("%c",220);
		gotoxy(79,i1);
		cprintf("%c",220);

	}


}
void side_line()
{
	int i,j;
	for(i=5;i<25;i++)
	{
	       gotoxy(5,i);
	       cprintf("Û");
	}
	gotoxy(3,22);
	cprintf("ÜÜÛÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜ");
	gotoxy(3,23);
	cprintf("  Û");

	for(j=3;j<22;j++)
	{

		gotoxy(75,j);
		cprintf("Û");
	}
	gotoxy(29,3);
	cprintf("ÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÛÜÜÜ");
	gotoxy(75,2);
	cprintf("Û");


}
/*
		case 3:
		cout << "Space used by class med_pro " << sizeof(med_store);
		cout << "Space used by class name " << sizeof(name) << endl;
		cout << "Space used by class stock " << sizeof(stock) << endl;
		cout << "Space used by class stock1 " << sizeof(stock1) << endl;
		cout << "Space used by class date" << sizeof(dop)  << endl;
*/