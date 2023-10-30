STACK_NAME=task-manager-stack

# Create the CloudFormation stack
aws cloudformation create-stack --stack-name $STACK_NAME --template-body file://infrastructure.yml --capabilities CAPABILITY_NAMED_IAM --region=eu-west-1

# Wait for the stack creation to complete
echo "Waiting for stack creation to complete..."
aws cloudformation wait stack-create-complete --stack-name $STACK_NAME
echo "Stack creation completed."

