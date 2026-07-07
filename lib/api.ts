import {BoundlessClient} from 'boundless-api-client';
import {mockApiClient} from './mockApi';

const baseURL = process.env.BOUNDLESS_API_BASE_URL;
const permanentToken = process.env.BOUNDLESS_API_PERMANENT_TOKEN;
const s3Prefix = process.env.BOUNDLESS_S3_PREFIX;
const mediaServer = process.env.BOUNDLESS_MEDIA_SERVER;

const useMockApi = !permanentToken || !process.env.BOUNDLESS_INSTANCE_ID;
const apiClient = useMockApi
	? mockApiClient as unknown as BoundlessClient
	: new BoundlessClient(permanentToken);

if (!useMockApi) {
	apiClient.setInstanceId(process.env.BOUNDLESS_INSTANCE_ID as unknown as number);
}

if (!useMockApi && baseURL) {
	apiClient.setBaseUrl(baseURL);
}

if (!useMockApi && s3Prefix) {
	apiClient.setS3FolderPrefix(s3Prefix);
}

if (!useMockApi && mediaServer) {
	apiClient.setMediaServerUrl(mediaServer);
}

export {apiClient};
