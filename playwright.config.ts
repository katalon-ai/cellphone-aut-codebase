import {defineConfig, devices} from '@playwright/test';

const targetUrls = {
	production: 'https://cellphoneshop-truetest-auto.netlify.app',
	staging: 'https://cellphoneshop-truetest-auto-staging.netlify.app',
} as const;

const targetEnv = (process.env.TARGET_ENV || 'staging').toLowerCase();
const baseURL = process.env.BASE_URL || targetUrls[targetEnv as keyof typeof targetUrls];
const browserChannel = process.env.BROWSER_CHANNEL;

if (!baseURL) {
	throw new Error(`Unknown TARGET_ENV "${targetEnv}". Use staging, production, or set BASE_URL.`);
}

export default defineConfig({
	testDir: './tests/e2e',
	fullyParallel: true,
	forbidOnly: !!process.env.CI,
	retries: process.env.CI ? 2 : 0,
	workers: 2,
	reporter: [
		['list'],
		['html', {open: 'never'}],
	],
	use: {
		baseURL,
		trace: 'retain-on-failure',
		screenshot: 'only-on-failure',
		video: 'retain-on-failure',
		viewport: {width: 1440, height: 1000},
		actionTimeout: 15000,
		navigationTimeout: 45000,
	},
	expect: {
		timeout: 15000,
	},
	projects: [
		{
			name: `${browserChannel || 'chromium'}-${targetEnv}`,
			use: {
				...devices['Desktop Chrome'],
				...(browserChannel ? {channel: browserChannel} : {}),
			},
		},
	],
});
