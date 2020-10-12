void arradd(void)
{
	int i,j;
	int r1,r2,c1,c2;
	int x[10][10],y[10][10],res[10][10];

	clrscr();

	printf("\nEnter the order of First Matrix:\n");
	scanf("%d%d",&r1,&c1);
	printf("\nEnter the order of Second Matrix:\n");
	scanf("%d%d",&r2,&c2);
	if(r1==c2)
	{
	printf("\nEnter the matrices elements:\n");
	printf("\nFor elements X");
	for(i=0;i<r1;i++)
	{
		for(j=0;j<c1;j++)
		{
			scanf("%d",&x[i][j]);
		}
	}
	printf("\nFor elements Y:\n");
	for(i=0;i<r2;i++)
	{
		for(j=0;j<c2;j++)
		{
			scanf("%d",&y[i][j]);
		}
	}
	printf("\nMatrix X elements:\n");
	for(i=0;i<r1;i++)
	{
		for(j=0;j<c1;j++)
		{
			printf("%5d",x[i][j]);
		}
		printf("\n");
	}
	printf("\nMatrix Y elements:\n");
	for(i=0;i<r2;i++)
	{
		for(j=0;j<c2;j++)
		{
			printf("%5d",y[i][j]);
		}
		printf("\n");
	}
	for(i=0;i<r1;i++)
	{
		for(j=0;j<c2;j++)
		{
			res[i][j]=x[i][j]+y[i][j];
		}
	}
	printf("\nAddition of Matrix:\n");
	for(i=0;i<r1;i++)
	{
		for(j=0;j<c2;j++)
		{
		       printf("%5d",res[i][j]);
		}
		printf("\n");
	}
	}
	else
	{
	printf("\nNot possible..");
	}


	getch();
}
