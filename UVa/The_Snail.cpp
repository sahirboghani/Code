#include <stdio.h>

int main() {
	
	int H, U, D, F;

	int day;
	float fatigue, days_travel, height;

	while(true) {
		scanf("%i %i %i %i", &H, &U, &D, &F);
		if(H == 0) 
			return 0;
		height = 0;
		day = 1;
		fatigue = U*F/100.0;
		days_travel = U + fatigue;
		while(true) {
			days_travel -= fatigue;
			if(days_travel > 0) 
				height += days_travel;
			if(height > H) {
				printf("success on day %i\n", day);
				break;
			}
			height -= D;
			if(height < 0) {
				printf("failure on day %i\n", day);
				break;
			}
			++day;
		}
	}
}