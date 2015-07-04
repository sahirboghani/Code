#include <stdio.h>

int main() {
	
	int duration, dep_records;
	float down_payment, loan, car_worth, payment;

	int cur_month, next_month;
	float cur_rate, next_rate;

	while(true) {
		scanf("%i %f %f %i", &duration, &down_payment, &loan, &dep_records);
		//printf("duration %i down payment %f loan %f dep_records %i", duration, down_payment, loan, dep_records);

		if(duration < 0)
			return 0;

		int next = 0;
		int vals1[dep_records], temp1;
		float vals2[dep_records], temp2;
		
		while(dep_records--) {
			scanf("%i %f", &temp1, &temp2);
			vals1[next] = temp1;
			vals2[next++] = temp2;
		}

		cur_month = vals1[0];
		cur_rate = vals2[0];
		if(next == 1) {
			next_month = -1;
		}
		else {
			next_month = vals1[1];
			next_rate = vals2[1];
		}

		next = 2;

		car_worth = loan + down_payment;
		//printf("\n%f\n", car_worth);
		car_worth -= car_worth*cur_rate;
		//printf("\n%f\n", car_worth);
		payment = loan/duration;

		//printf("\n\nWorth %f\nPayment %f \nloan %f\n Current Rate %f\n\n", car_worth, payment, loan, cur_rate);

		if(loan < car_worth) {
			printf("0 months\n");
		}
		else {
			int i = 1;
			//printf("i: %i\n", i);


			while(loan > car_worth) {

			//	printf("i: %i\n", i);


				if(next_month == i) {
					cur_month = next_month;
					cur_rate = next_rate;
					if(next == (sizeof(vals1)/sizeof(*vals1))) {
						next_month = -1;
					}
					else {
						next_month = vals1[next];
						next_rate = vals2[next++];
					}
				}

				car_worth -= car_worth*cur_rate;
				loan -= payment;

			//	printf("i: %i\n", i);

				++i;
			}
			--i;
			if(i == 1)
				printf("1 month\n");
			else
				printf("%i months\n", i);
		}
	}

	return 0;
}