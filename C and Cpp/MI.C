#include <stdio.h>
#include <conio.h>
#include "line.c"
#include "cube.c"
#include "arradd.c"
#include "cuboid.c"
#include "mult.c"
#include "square.c"
#include "radius.c"
#include "rectangl.c"
#include "para.c"
#include "trans.c"
#include "cy.c"
#include "new.c"
void main(void)
{

	int ch1,ch3,ch4,ch5;
	clrscr();

	textcolor(WHITE); gotoxy(34,11);
	cprintf("WELCOME TO OUR PROJECT");
	sleep(2);
	clrscr();
	new();
	clrscr();
	line();
	printf("\n");
	printf("\n\t\t\tษอออออออออออออออออออออออออออออออป");
	printf("\n\t\t\tบ\t  Maths Tutorial\tบ");
	printf("\n\t\t\tศอออออออออออออออออออออออออออออออผ");
	h:
	printf("\n\n\nENTER YOUR CHOICE:\n");
	printf("\n\nฏPress 1 for 2D-Shapes operation.\nฏPress 2 for 3D-Shapes operation.\nฏPress 3 for Matrix operation.\n");
	scanf("%d",&ch1);
	switch(ch1)
	{
		case 1:
		{
			int ch3;
			clrscr();
			printf("What operation do you want:\n");
			printf("1]Square.\t2]Rectangle.\n3]Cirlce.\t4]Parallelogram:\n");
			scanf("%d",&ch3);
			switch(ch3)
			{
				case 1:
				sqr();
				break;

				case 2:
				rect();
				break;

				case 3:
				rad();
				break;

				case 4:
				para();
				break;

				default:
				printf("INVALID....");
			}
		}
		break;

		case 2:
		{
			int ch4;
			clrscr();
			printf("What do you want to perform:\n");
			printf("1]Cube.\t2]Cuboid\n3]Cylinder\n");
			scanf("%d",&ch4);
			switch(ch4)
			{
				case 1:
				cube();
				break;

				case 2:
				cuboid();
				break;

				case 3:
				cy();
				break;

				default:
				printf("INVALID....");
			}
		}
		break;
		case 3:
		{
			int ch5;
			clrscr();
			printf("What do you want to perform:\n");
			printf("\n1]ADDITION OF MATRIX.\t2]MULTIPLICATION OF MAATRIX.\n3]TRANSPOSE OF MATRIX\n");
			scanf("%d",&ch5);
			switch(ch5)
			{
				case 1:
				arradd();
				break;

				case 2:
				mult();
				break;

				case 3:
				trans();
				break;

				default:
				printf("INVALID..");
			}
		}
		break;
		default:
		printf("INALID...");
	}
	printf("\n\nDO YOU WANT TO THIS AGAIN:\n");
	printf("\nPress 1 for Yes & 2 for No:\n");
	scanf("%d",&ch1);
	if(ch1==1)
	{
		clrscr();
		goto h;

	}
	else
	{
		goto End;
	}
	End:
	clrscr();
	textcolor(YELLOW); gotoxy(36,10);

	cprintf("Program Ended");

	getch();
}
















